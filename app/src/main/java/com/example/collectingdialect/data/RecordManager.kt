package com.example.collectingdialect.data

import android.media.MediaMetadataRetriever
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.SharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import zeroonezero.android.audio_mixer.AudioMixer
import zeroonezero.android.audio_mixer.input.BlankAudioInput
import zeroonezero.android.audio_mixer.input.GeneralAudioInput
import java.io.File

object RecordManager {
    private const val MIN_RECORD_TIME_TYPE_ONE_PERSON = 50 * 60 * 1000
    private const val MIN_RECORD_TIME_TYPE_TWO_PERSON = 25 * 60 * 1000

    private val REQUIRE_RECORD_COUNT_TYPE_ONE_PERSON: Int
        get() {
            val selectedRegion = sharedViewModel?.currentSpeakerInfo?.residenceProvince
            val selectedSet = sharedViewModel?.selectedSet
            return ContentData.getRequireRecordCountTypeOnePerson(selectedRegion, selectedSet)
        }
    private val REQUIRE_RECORD_COUNT_TYPE_TWO_PERSON: Int
        get() {
            val selectedRegion = sharedViewModel?.currentSpeakerInfo?.residenceProvince
            val selectedSet = sharedViewModel?.selectedSet
            return ContentData.getRequireRecordCountTypeTwoPerson(selectedRegion, selectedSet)
        }

    var sharedViewModel: SharedViewModel? = null
    var recordTimeUpdateCallback: RecordTimeUpdateCallback? = null

    fun clearRecordDirectory() {
        val context = MainActivity.contextRequester?.invoke() ?: return
        val mediaDirectory = context.filesDir
        val recordList = mediaDirectory.listFiles() ?: return
        recordList.forEach {
            it.delete()
        }
    }

    private fun calculateRecordTime(): Long {
        val context = MainActivity.contextRequester?.invoke() ?: return 0
        val mediaDirectory = context.filesDir
        val recordList = mediaDirectory?.listFiles() ?: emptyArray()
        var recordTimeMillis: Long = 0
        recordList.forEach { file ->
            MediaMetadataRetriever().apply {
                try {
                    setDataSource(file.absolutePath)
                    val duration = extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)?.toLong() ?: 0
                    recordTimeMillis += duration
                } catch (e: Exception) {
                    // do nothing
                }
            }
        }
        return recordTimeMillis
    }

    fun updateRecordTime() {
        val recordTimeMillis: Long = calculateRecordTime()
        val minutes: Long = (recordTimeMillis / 1000) / 60
        val seconds: Long = (recordTimeMillis / 1000) % 60
        recordTimeUpdateCallback?.onUpdateRecordTime(String.format("%02d:%02d", minutes, seconds))
    }

    private fun updateRecordTime(recordTimeMillis: Long) {
        val minutes: Long = (recordTimeMillis / 1000) / 60
        val seconds: Long = (recordTimeMillis / 1000) % 60
        recordTimeUpdateCallback?.onUpdateRecordTime(String.format("%02d:%02d", minutes, seconds))
    }

    private fun validateRecordCount(collectingType: Int): Boolean {
        val context = MainActivity.contextRequester?.invoke() ?: return false
        val mediaDirectory = context.filesDir
        val recordList = mediaDirectory?.listFiles() ?: emptyArray()
        return when(collectingType) {
            SharedViewModel.COLLECTING_TYPE_ONE_PERSON -> {
                recordList.size == REQUIRE_RECORD_COUNT_TYPE_ONE_PERSON
            }
            SharedViewModel.COLLECTING_TYPE_TWO_PERSON -> {
                for(i in 0 until REQUIRE_RECORD_COUNT_TYPE_TWO_PERSON) {
                    recordList.find { file ->
                        file.name.startsWith("conversation_$i")
                    } ?: return false
                }
                true
            }
            else -> {
                false
            }
        }
    }

    private fun validateRecordTime(collectingType: Int): Boolean {
        val recordTimeMillis = calculateRecordTime()
        return when(collectingType) {
            SharedViewModel.COLLECTING_TYPE_ONE_PERSON -> {
                recordTimeMillis >= MIN_RECORD_TIME_TYPE_ONE_PERSON
            }
            SharedViewModel.COLLECTING_TYPE_TWO_PERSON -> {
                recordTimeMillis >= MIN_RECORD_TIME_TYPE_TWO_PERSON
            }
            else -> {
                false
            }
        }
    }

    fun validateRecord(collectingType: Int): Boolean {
        return validateRecordCount(collectingType) && validateRecordTime(collectingType)
    }

    private var isRecording: Boolean = false

    fun onStartRecording() {
        isRecording = true
        var recordTimeMillis = calculateRecordTime()
        updateRecordTime(recordTimeMillis)
        CoroutineScope(Dispatchers.Main).launch {
            while (isRecording) {
                delay(1000)
                recordTimeMillis += 1000
                if(!isRecording) {
                    break
                }
                updateRecordTime(recordTimeMillis)
            }
        }
    }

    fun onStopRecording() {
        isRecording = false
        updateRecordTime()
    }

    fun integrateRecording(onComplete: () -> Unit) {
        val context = MainActivity.contextRequester?.invoke() ?: return
        val mediaDirectory = context.filesDir
        val recordList = mediaDirectory?.listFiles() ?: emptyArray()
        var outputFile: File
        var audioMixer: AudioMixer
        var audioInput: GeneralAudioInput
        val blankInput = BlankAudioInput(500000)
        var completedProcessCount = 0

        for(i in 0 until REQUIRE_RECORD_COUNT_TYPE_TWO_PERSON) {
            outputFile = File(mediaDirectory, "conversation_$i.mp4")
            audioMixer = AudioMixer(outputFile.absolutePath)
            val filteredRecordList = recordList.filter { file ->
                file.name.startsWith("conversation_$i")
            }
            if(filteredRecordList.isNotEmpty()) {
                filteredRecordList.forEachIndexed { index, file ->
                    audioInput = GeneralAudioInput(file.absolutePath)
                    audioMixer.addDataSource(audioInput)
                    /*if(index != filteredRecordList.lastIndex) {
                        audioMixer.addDataSource(blankInput)
                    }*/
                }
                audioMixer.setSampleRate(44100); // Optional
                audioMixer.setBitRate(128000); // Optional
                audioMixer.setChannelCount(2); // Optional //1(mono) or 2(stereo)
                audioMixer.mixingType = AudioMixer.MixingType.PARALLEL
                audioMixer.isLoopingEnabled = false
                audioMixer.setProcessingListener(object: AudioMixer.ProcessingListener{
                    override fun onProgress(progress: Double) {
                        //do nothing
                    }

                    override fun onEnd() {
                        audioMixer.release()
                        completedProcessCount += 1
                        if(completedProcessCount == REQUIRE_RECORD_COUNT_TYPE_TWO_PERSON) {
                            onComplete.invoke()
                        }
                    }
                })
                audioMixer.start()
                audioMixer.processAsync()
            } else {
                completedProcessCount += 1
                if(completedProcessCount == REQUIRE_RECORD_COUNT_TYPE_TWO_PERSON) {
                    onComplete.invoke()
                }
            }
        }
    }
}