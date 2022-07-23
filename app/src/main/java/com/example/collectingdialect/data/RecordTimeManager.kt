package com.example.collectingdialect.data

import android.content.Context
import android.media.MediaMetadataRetriever
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.collecting.CollectingViewModel
import com.example.collectingdialect.ui.login.LoginViewModel

object RecordTimeManager {
    private const val MIN_SCRIPT_RECORD_TIME = 18 * 60 * 1000
    private const val MIN_CONVERSATION_RECORD_TIME = 30 * 60 * 1000
    private const val MIN_VIRTUAL_PARTNER_RECORD_TIME = 12 * 60 * 1000

    private const val REQUIRE_SCRIPT_RECORD_FILE_COUNT = 90

    var recordTimeUpdateCallback: RecordTimeUpdateCallback? = null

    private var scriptRecordTime: Long = 0
    private var conversationRecordTime: Long = 0
    private var virtualPartnerRecordTime: Long = 0

    fun updateRecordTime() {
        val context = MainActivity.contextRequester?.invoke() ?: return
        val currentUserName = context.getSharedPreferences(LoginViewModel.PREFERENCE_USER, Context.MODE_PRIVATE).getString(LoginViewModel.KEY_ID, "") ?: ""
        val mediaDirectory = context.filesDir
        //val recordList = mediaDirectory?.listFiles() ?: emptyArray()
        val recordList = mediaDirectory?.listFiles{ file ->
            file.name.startsWith(currentUserName)
        } ?: emptyArray()
        var recordTimeMillis: Long = 0
        recordList.forEach { file ->
            MediaMetadataRetriever().apply {
                try {
                    setDataSource(file.absolutePath)
                    val duration = extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)?.toLong() ?: 0
                    recordTimeMillis += duration
                    if(file.name.startsWith("${currentUserName}_${CollectingViewModel.TYPE_SCRIPT}")) {
                        scriptRecordTime += duration
                    }else if(file.name.startsWith("${currentUserName}_${CollectingViewModel.TYPE_CONVERSATION}")) {
                        conversationRecordTime += duration
                    }else if(file.name.startsWith("${currentUserName}_${CollectingViewModel.TYPE_SCRIPT}")) {
                        virtualPartnerRecordTime += duration
                    }
                } catch (e: Exception) {
                    // do nothing
                }
            }
        }
        val minutes: Long = (recordTimeMillis / 1000) / 60
        val seconds: Long = (recordTimeMillis / 1000) % 60
        recordTimeUpdateCallback?.onUpdateRecordTime(String.format("%02d분 %02d초", minutes, seconds))
    }

    fun checkStructuredIsComplete(): Boolean {
        val context = MainActivity.contextRequester?.invoke() ?: return false
        val currentUserName = context.getSharedPreferences(LoginViewModel.PREFERENCE_USER, Context.MODE_PRIVATE).getString(LoginViewModel.KEY_ID, "") ?: ""
        val mediaDirectory = context.filesDir
        val recordList = mediaDirectory?.listFiles{ file ->
            file.name.startsWith("${currentUserName}_${CollectingViewModel.TYPE_SCRIPT}")
        } ?: emptyArray()
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
        return (recordList.size == REQUIRE_SCRIPT_RECORD_FILE_COUNT) && (recordTimeMillis >= MIN_SCRIPT_RECORD_TIME)
    }

    fun validateRecordTime(): Boolean {
        return if(scriptRecordTime < MIN_SCRIPT_RECORD_TIME) {
            showToast("정형발화의 녹음 시간이 부족합니다. 다시 녹음해주세요")
            false
        } else if(conversationRecordTime < MIN_CONVERSATION_RECORD_TIME) {
            showToast("비정형발화-수집자와의 2인 대화의 녹음 시간이 부족합니다. 다시 녹음해주세요")
            false
        } else if(virtualPartnerRecordTime < MIN_VIRTUAL_PARTNER_RECORD_TIME) {
            showToast("비정형발화-가상 상대와의 대화의 녹음 시간이 부족합니다. 다시 녹음해주세요")
            false
        } else {
            true
        }
    }

    private fun initializeRecordTime() {
        scriptRecordTime = 0
        conversationRecordTime = 0
        virtualPartnerRecordTime = 0
    }
}