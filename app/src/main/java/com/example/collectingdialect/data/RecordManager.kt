package com.example.collectingdialect.data

import android.graphics.Color
import android.media.MediaMetadataRetriever
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.core.view.allViews
import androidx.core.view.updateLayoutParams
import com.example.collectingdialect.remote.ApiManager
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.collecting.CollectingViewModel
import com.example.collectingdialect.ui.collecting.InfoViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

object RecordManager {
    const val KEY_LAST_RECORD_CHECK_TIME_MILLIS = "last_check"
    const val TIME_24_HOUR_MILLIS = 60 * 60 * 1000

    private val mediaDirectory: File?
        get() = MainActivity.contextRequester?.invoke()?.filesDir

    var onToolbarRecordTimeChangeListener: OnToolbarRecordTimeChangeListener? = null

    private fun calculateRecordTime(recordDirectory: File?, fileNamePrefix: String?): Long {
        val recordList = if(fileNamePrefix != null) {
            recordDirectory?.listFiles { file ->
                file.name.startsWith(fileNamePrefix)
            } ?: emptyArray()
        } else {
            recordDirectory?.listFiles() ?: emptyArray()
        }
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

    fun updateToolbarRecordTime(isVisible: Boolean, recordDirectory: File?) {
        if(isVisible) {
            val recordTimeMillis: Long = calculateRecordTime(recordDirectory, null)
            val minutes: Long = (recordTimeMillis / 1000) / 60
            val seconds: Long = (recordTimeMillis / 1000) % 60
            onToolbarRecordTimeChangeListener?.onChangeRecordTime(String.format("%02d:%02d", minutes, seconds))
        } else {
            onToolbarRecordTimeChangeListener?.onChangeRecordTime("")
        }
    }

    private fun updateToolbarRecordTime(recordTimeMillis: Long) {
        val minutes: Long = (recordTimeMillis / 1000) / 60
        val seconds: Long = (recordTimeMillis / 1000) % 60
        onToolbarRecordTimeChangeListener?.onChangeRecordTime(String.format("%02d:%02d", minutes, seconds))
    }

    fun getRecordDirectory(contentName: String, collectorId: String, speakerId: String): File {
        val recordDirectory = File(mediaDirectory, "${contentName}_${collectorId}_$speakerId")
        if(!recordDirectory.exists()) {
            recordDirectory.mkdir()
        }
        return recordDirectory
    }

    private var isRecording: Boolean = false

    fun onStartRecording(
        recordDirectory: File?,
        fileName: String,
        additionalCallback: (Long) -> Unit
    ) {
        isRecording = true
        var totalRecordTimeMillis = calculateRecordTime(recordDirectory, null)
        var recordTimeMillis: Long = calculateRecordTime(recordDirectory, fileName)
        updateToolbarRecordTime(totalRecordTimeMillis)
        additionalCallback.invoke(recordTimeMillis)
        CoroutineScope(Dispatchers.Main).launch {
            while (isRecording) {
                delay(1000)
                totalRecordTimeMillis += 1000
                recordTimeMillis += 1000
                if(!isRecording) {
                    break
                }
                updateToolbarRecordTime(totalRecordTimeMillis)
                additionalCallback.invoke(recordTimeMillis)
            }
        }
    }

    fun onStopRecording(recordDirectory: File?) {
        isRecording = false
        updateToolbarRecordTime(true, recordDirectory)
    }

    fun getRecordTime(recordDirectory: File?, fileName: String): String {
        val recordTimeMillis = calculateRecordTime(recordDirectory, fileName)
        val minutes: Long = (recordTimeMillis / 1000) / 60
        val seconds: Long = (recordTimeMillis / 1000) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    fun getRecordListStartWith(recordDirectory: File?, fileNamePrefix: String): Array<File> {
        return recordDirectory?.listFiles { file ->
            file.name.startsWith(fileNamePrefix)
        }?: emptyArray()
    }

    fun checkAndUploadRecord() {
        val recordDirectoryList = mediaDirectory?.listFiles() ?: emptyArray()
        val currentTimeMillis = System.currentTimeMillis()
        val filteredRecordDirectoryList = recordDirectoryList.filter {
            currentTimeMillis - it.lastModified() > TIME_24_HOUR_MILLIS
        }.toTypedArray()
        if(filteredRecordDirectoryList.isNotEmpty()) {
            uploadDirectory(filteredRecordDirectoryList)
        }
    }

    fun uploadRecord() {
        val recordDirectoryList = mediaDirectory?.listFiles() ?: emptyArray()
        if(recordDirectoryList.isNotEmpty()) {
            uploadDirectory(recordDirectoryList)
        }
    }

    private fun uploadDirectory(directoryList: Array<File>) {
        val context = MainActivity.contextRequester?.invoke() ?: kotlin.run {
            showToast("오류. 앱을 재시작 후 다시 시도해주세요")
            return
        }
        val progressBar = ProgressBar(context).apply {
            layoutParams = ViewGroup.LayoutParams(0, 0)
        }
        val progressDialog = MaterialAlertDialogBuilder(context)
            .setView(progressBar)
            .setCancelable(false)
            .create()
        progressDialog.setOnShowListener {
            (it as AlertDialog).window?.apply {
                setLayout(300, 300)
                decorView.setBackgroundColor(Color.TRANSPARENT)
                progressBar.updateLayoutParams {
                    width = 300
                    height = 300
                }
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            var toUploadDirectory = 0
            var uploadCompletedDirectory = 0

            CoroutineScope(Dispatchers.Main).launch {
                showToast("데이터 전송중입니다")
                progressDialog.show()
            }.join()

            for (i in directoryList.indices) {
                val directory = directoryList[i]
                if (!directory.isDirectory) {
                    continue
                }
                toUploadDirectory += 1
                if(directory.listFiles()?.isEmpty() == true) {
                    directory.delete()
                    uploadCompletedDirectory += 1
                    continue
                }

                val directoryNameSplit = directory.nameWithoutExtension.split("_")
                val contentName: String = try {
                    directoryNameSplit[0]
                } catch (e: IndexOutOfBoundsException) {
                    ""
                }
                val collectorId: String = try {
                    directoryNameSplit[1]
                } catch (e: IndexOutOfBoundsException) {
                    "unknownCollector"
                }
                val speakerId1: String = try {
                    directoryNameSplit[2]
                } catch (e: IndexOutOfBoundsException) {
                    "unknownSpeaker"
                }
                val speakerId2: String = try {
                    directoryNameSplit[3]
                } catch (e: IndexOutOfBoundsException) {
                    "unknownSpeaker"
                }

                try {
                    when (contentName) {
                        CollectingViewModel.CONTENT_NAME_REPEAT -> {
                            val repeatRecordList = directory.listFiles() ?: emptyArray()
                            if (repeatRecordList.isNotEmpty()) {
                                val repeatRecordParams = mapOf(
                                    "classNum" to 1.toString(),
                                    "collectorId" to collectorId,
                                    "speakerId1" to speakerId1,
                                    "className" to CollectingViewModel.CONTENT_NAME_REPEAT,
                                )
                                val repeatRecordMultipart =
                                    createFilesMultiPart(repeatRecordParams, repeatRecordList)
                                val response =
                                    ApiManager.apiService.sendRecordData(repeatRecordMultipart)
                                        .execute()
                                if (response.isSuccessful) {
                                    repeatRecordList.forEach { file ->
                                        file.delete()
                                    }
                                    if (directory.listFiles()?.size == 0) {
                                        InfoViewModel.deleteInfo(speakerId1)
                                        directory.delete()
                                    }
                                }
                            }
                        }
                        CollectingViewModel.CONTENT_NAME_QNA -> {
                            val qnaRecordList = directory.listFiles() ?: emptyArray()
                            if (qnaRecordList.isNotEmpty()) {
                                val qnaRecordParams = mapOf(
                                    "classNum" to 1.toString(),
                                    "collectorId" to collectorId,
                                    "speakerId1" to speakerId1,
                                    "className" to CollectingViewModel.CONTENT_NAME_QNA,
                                )
                                val qnaRecordMultipart =
                                    createFilesMultiPart(qnaRecordParams, qnaRecordList)
                                val response =
                                    ApiManager.apiService.sendRecordData(qnaRecordMultipart).execute()
                                if (response.isSuccessful) {
                                    qnaRecordList.forEach { file ->
                                        file.delete()
                                    }
                                    if (directory.listFiles()?.size == 0) {
                                        InfoViewModel.deleteInfo(speakerId1)
                                        directory.delete()
                                    }
                                }
                            }
                        }
                        CollectingViewModel.CONTENT_NAME_CONVERSATION -> {
                            val conversationRecordList = directory.listFiles() ?: emptyArray()
                            if (conversationRecordList.isNotEmpty()) {
                                val conversationRecordParams = if (collectorId == speakerId2) {
                                    mapOf(
                                        "classNum" to 3.toString(),
                                        "collectorId" to collectorId,
                                        "speakerId1" to speakerId1,
                                        "className" to CollectingViewModel.CONTENT_NAME_CONVERSATION,
                                    )
                                } else {
                                    mapOf(
                                        "classNum" to 2.toString(),
                                        "collectorId" to collectorId,
                                        "speakerId1" to speakerId1,
                                        "speakerId2" to speakerId2,
                                        "className" to CollectingViewModel.CONTENT_NAME_CONVERSATION,
                                    )
                                }
                                val conversationRecordMultipart =
                                    createFilesMultiPart(conversationRecordParams, conversationRecordList)
                                val response =
                                    ApiManager.apiService.sendRecordData(conversationRecordMultipart)
                                        .execute()
                                if (response.isSuccessful) {
                                    conversationRecordList.forEach { file ->
                                        file.delete()
                                    }
                                    if (directory.listFiles()?.size == 0) {
                                        directory.delete()
                                    }
                                }
                            }
                        }
                    }
                    uploadCompletedDirectory += 1
                } catch (e: Exception) {
                    e.printStackTrace()
                    FirebaseCrashlytics.getInstance().recordException(e)
                    continue
                }
            }

            CoroutineScope(Dispatchers.Main).launch {
                if(uploadCompletedDirectory == 0) {
                    showToast("업로드 실패. 잠시 후 다시 시도해주세요.")
                } else if(uploadCompletedDirectory != toUploadDirectory) {
                    showToast("일부 데이터 업로드 실패. 잠시 후 다시 시도해주세요.")
                } else if(uploadCompletedDirectory == toUploadDirectory) {
                    showToast("서버에 데이터 업로드를 완료하였습니다.")
                }
                progressDialog.dismiss()
            }.join()
        }
    }

    private fun createFilesMultiPart(params: Map<String, String>, fileList: Array<File>): List<MultipartBody.Part> {
        val tempList = arrayListOf<MultipartBody.Part>()
        params.forEach { entry ->
            tempList.add(MultipartBody.Part.createFormData(entry.key, entry.value))
        }
        fileList.forEach { file ->
            tempList.add(MultipartBody.Part.createFormData("recfile", file.name, file.asRequestBody()))
        }
        return tempList.toList()
    }
}