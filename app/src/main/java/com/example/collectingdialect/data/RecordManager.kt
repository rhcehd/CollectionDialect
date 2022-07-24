package com.example.collectingdialect.data

import android.media.MediaMetadataRetriever
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.SharedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        recordTimeUpdateCallback?.onUpdateRecordTime(String.format("%02d분 %02d초", minutes, seconds))
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
                recordList.size == REQUIRE_RECORD_COUNT_TYPE_TWO_PERSON
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
        val recordTimeMillis = calculateRecordTime()
        CoroutineScope(Dispatchers.Main).launch {
            while (isRecording) {
                if(!isRecording) {
                    break
                }

            }
        }
    }

    fun onStopRecording() {
        isRecording = false
        updateRecordTime()
    }
}