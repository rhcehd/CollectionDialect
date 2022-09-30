package com.mtdata.aidev.collectingdialect.ui.collecting

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.view.View
import androidx.annotation.RawRes
import androidx.databinding.Bindable
import com.mtdata.aidev.collectingdialect.BR
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.record.RecordManager
import com.mtdata.aidev.collectingdialect.ui.BaseViewModel
import com.mtdata.aidev.collectingdialect.ui.MainActivity.Companion.showToast
import com.mtdata.aidev.collectingdialect.ui.SharedViewModel
import com.github.squti.androidwaverecorder.WaveRecorder
import java.io.File
import java.util.*

open class CollectingViewModel: BaseViewModel() {
    companion object {
        const val CONTENT_NAME_REPEAT = "st"
        const val CONTENT_NAME_QNA = "say"
        const val CONTENT_NAME_CONVERSATION = "talk"
    }
    var sharedViewModel: SharedViewModel? = null
        private set

    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var waveRecorder = WaveRecorder("")

    protected var isConversationType: Boolean = false

    private var collectorId: String = ""
    private var speakerId: String = ""
    protected var contentName: String = ""
    protected var setName: String = ""
    protected var firstIndex: String = ""
        set(value) {
            field = value
            initializeMediaPlayer(null)
            if(adapterEnabled) {
                adapter.refreshRecordList(recordDirectory, fileNamePrefix)
            }
            recordTime = RecordManager.getRecordTime(recordDirectory, fileName)
        }
    private val secondIndex: String
        get() = if(adapterEnabled) {
            adapter.itemCount.toString()
        } else {
            ""
        }
    var recordDirectory: File? = null
        private set
    private val fileName: String
        get() = if(adapterEnabled) {
            //"${contentName}_${setName}_${collectorId}_${speakerId}_${firstIndex}_$secondIndex.mp4"
            "${contentName}_${setName}_${collectorId}_${speakerId}_${firstIndex}_$secondIndex.wav"
        } else {
            //"${contentName}_${setName}_${collectorId}_${speakerId}_${firstIndex}.mp4"
            "${contentName}_${setName}_${collectorId}_${speakerId}_${firstIndex}.wav"
        }
    private val fileNamePrefix: String
        get() = if(adapterEnabled) {
            "${contentName}_${setName}_${collectorId}_${speakerId}_${firstIndex}"
        } else {
            "${contentName}_${setName}_${collectorId}_${speakerId}"
        }

    var adapter = RecordAdapter {this}
    var adapterEnabled: Boolean = false
        set(value) {
            field = value
            if(field) {
                adapter.refreshRecordList(recordDirectory, fileNamePrefix)
            }
        }

    var recordTime: String = "00:00"
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.recordTime)
            }
        }

    private val recordTimeCallback = { recordTimeMillis: Long ->
        val minutes: Long = (recordTimeMillis / 1000) / 60
        val seconds: Long = (recordTimeMillis / 1000) % 60
        recordTime = String.format("%02d:%02d", minutes, seconds)
    }
    var isRecording: Boolean = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.recording)
            }
        }

    var isRecordExist = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.recordExist)
            }
        }
    var activatedRecordButtonHashCode: Int? = null

    open fun initializeWithSharedViewModel(sharedViewModel: SharedViewModel) {
        this.sharedViewModel = sharedViewModel
        val collectorId = sharedViewModel.collectorId
        val speakerId1 = sharedViewModel.currentSpeaker1Info?.speakerId
        val speakerId2 = sharedViewModel.currentSpeaker2Info?.speakerId
        speakerId = if(isConversationType) {
            if(speakerId2.isNullOrEmpty()) {
                val provinceResidence = InfoViewModel.residenceProvinceValueOf(
                    sharedViewModel.currentSpeaker1Info?.residenceProvince ?: ""
                )
                val randomId = "speaker${provinceResidence}${Random().nextInt(9999)}"
                "${speakerId1 ?: "unknownSpeaker"}_${randomId}"
            } else {
                "${speakerId1 ?: "unknownSpeaker"}_${speakerId2}"
            }
        } else {
            speakerId1 ?: "unknownSpeaker"
        }
        this.collectorId = collectorId ?: "unknownCollector"

        recordDirectory = RecordManager.getRecordDirectory(contentName, this.collectorId, speakerId)
        recordTime = RecordManager.getRecordTime(recordDirectory, fileName)
    }

    private fun initializeMediaPlayer(fileName: String?) {
        mediaPlayer = MediaPlayer().apply {
            isRecordExist = try {
                val file = File(recordDirectory, fileName ?: this@CollectingViewModel.fileName)
                setDataSource(file.absolutePath)
                prepare()
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    private fun startRecord(fileName: String?) {
        try {
            val filePathString = File(recordDirectory, fileName ?: this.fileName).absolutePath
            waveRecorder.changeFilePath(filePathString)
            waveRecorder.startRecording()
            RecordManager.onStartRecording(
                recordDirectory,
                fileName ?: this.fileName,
                recordTimeCallback
            )
            isRecording = true
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun stopRecord() {
        try {
            waveRecorder.stopRecording()
            RecordManager.onStopRecording(recordDirectory)
            isRecording = false
            initializeMediaPlayer(null)
            if(adapterEnabled) {
                adapter.refreshRecordList(recordDirectory, fileNamePrefix)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun onClickRecordButton(view: View) {
        onClickRecordButton(view, null)
    }

    fun onClickRecordButton(view: View, fileName: String?) {
        if(mediaPlayer?.isPlaying == true) {
            return
        }
        activatedRecordButtonHashCode = if(activatedRecordButtonHashCode == null) {
            view.hashCode()
        } else {
            if(activatedRecordButtonHashCode == view.hashCode()) {
                null
            } else {
                return
            }
        }

        if(isRecording) {
            try {
                stopRecord()
                if(fileName != null) {
                    view.setBackgroundResource(R.drawable.re_recording)
                } else {
                    view.setBackgroundResource(R.drawable.start_recording)
                }
            } catch (e: Exception) {

            }
        } else {
            try {
                startRecord(fileName)
                view.setBackgroundResource(R.drawable.recording)
            } catch (e: Exception) {

            }
        }
    }

    fun onClickPlayButton(view: View) {
        onClickPlayButton(view, null)
    }

    open fun onClickPlayButton(view: View, fileName: String?) {
        try {
            if(mediaPlayer?.isPlaying == true) {
                return
            }
            if(mediaRecorder != null) {
                return
            }
            initializeMediaPlayer(fileName)
            mediaPlayer?.start() ?: showToast("파일을 재생할 수 없습니다")
        } catch (e: Exception) {
            showToast("파일을 재생할 수 없습니다")
        }
    }

    fun onClickRecordListRecordButton(view: View, fileName: String) {
        onClickRecordButton(view, fileName)
    }

    fun onClickRecordListPlayButton(view: View, fileName: String) {
        onClickPlayButton(view, fileName)
    }

    fun playScript(context: Context, @RawRes resId: Int) {
        try {
            if(mediaPlayer?.isPlaying == true) {
                return
            }
            if(mediaRecorder != null) {
                return
            }
            mediaPlayer = MediaPlayer.create(context, resId)
            mediaPlayer?.start() ?: showToast("파일을 재생할 수 없습니다")
        } catch (e: Exception) {
            showToast("파일을 재생할 수 없습니다")
        }
    }

    fun onChangeUIState() {
        try {
            if(mediaPlayer?.isPlaying == true) {
                mediaPlayer?.stop()
            }
            stopRecord()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun onFragmentPause() {
        onChangeUIState()
        RecordManager.updateToolbarRecordTime(false, recordDirectory)
    }

    fun onFragmentResume() {
        onChangeUIState()
        RecordManager.updateToolbarRecordTime(true, recordDirectory)
    }
}