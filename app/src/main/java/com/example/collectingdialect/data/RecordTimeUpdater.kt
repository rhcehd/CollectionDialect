package com.example.collectingdialect.data

import android.media.MediaMetadataRetriever
import com.example.collectingdialect.ui.MainActivity

object RecordTimeUpdater {
    var recordTimeUpdateCallback: RecordTimeUpdateCallback? = null

    fun updateRecordTime() {
        val context = MainActivity.contextRequester?.invoke() ?: return
        val mediaDirectory = context.filesDir
        val recordList = mediaDirectory?.listFiles() ?: emptyArray()
        var recordTimeMillis: Long = 0
        recordList.forEach { record ->
            MediaMetadataRetriever().apply {
                try {
                    setDataSource(record.absolutePath)
                    val duration = extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)?.toLong() ?: 0
                    recordTimeMillis += duration
                } catch (e: Exception) {
                    // do nothing
                }
            }
        }
        val minutes: Long = (recordTimeMillis / 1000) / 60
        val seconds: Long = (recordTimeMillis / 1000) % 60
        recordTimeUpdateCallback?.onUpdateRecordTime(String.format("%02d분 %02d초", minutes, seconds))
    }
}