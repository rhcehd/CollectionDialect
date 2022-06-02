package com.example.collectingdialect.ui.collecting

import android.content.Context
import android.media.*
import android.os.Build
import android.view.View
import com.example.collectingdialect.R
import com.example.collectingdialect.data.RecordTimeUpdater
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import java.io.File
import java.io.IOException

open class CollectingViewModel: BaseViewModel() {
    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var mediaDirectory: File? = null
    var fileName: String = ""
        set(value) {
            field = value
            mediaPlayer = null
        }
    var isRecording: Boolean = false

    var currentSubject = ""
        /*set(value) {
            field = value
            fileName = "test_script_${currentSubject}_$dialectScriptIndex"
        }*/

    init {
        val context = MainActivity.contextRequester?.invoke()
        if(context == null) {
            showToast("올바르지 않은 동작입니다. 앱을 완전히 종료 후 다시 시도해주세요")
        } else {
            mediaDirectory = context.filesDir
        }
    }

    private fun initializeMediaRecorder(context: Context) {
        mediaRecorder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        } else {
            MediaRecorder()
        }
        mediaRecorder?.apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.HE_AAC)
        }
    }

    open fun onClickRecordButton(view: View) {
        if(isRecording) {
            isRecording = false
            view.setBackgroundResource(R.drawable.start_recording)
            mediaRecorder?.apply {
                stop()
                reset()
                release()
                RecordTimeUpdater.updateRecordTime()
            }
            this.mediaRecorder = null
        } else {
            isRecording = true
            view.setBackgroundResource(R.drawable.recording)
            val context = MainActivity.contextRequester?.invoke()
            if(context == null) {
                showToast("올바르지 않은 동작입니다. 앱을 완전히 종료 후 다시 시도해주세요")
            } else {
                initializeMediaRecorder(context)
                val outputFile = File(mediaDirectory, "$fileName.mp4")
                mediaRecorder?.apply {
                    setOutputFile(outputFile.absolutePath)
                    prepare()
                    start()
                }
            }
        }
    }

    open fun onClickPlayButton(view: View) {
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer().apply {
                try {
                    val file = File(mediaDirectory, "$fileName.mp4")
                    setDataSource(file.absolutePath)
                    prepare()
                    start()
                } catch (e: Exception) {
                    if(e is IOException) {
                        showToast("녹음되지 않은 항목입니다")
                    } else {
                        showToast("파일을 재생할 수 없습니다")
                    }
                }
            }
        } else {
            mediaPlayer?.start() ?: showToast("파일을 재생할 수 없습니다")
        }
    }

    open fun setSubject(subject: String) {
        currentSubject = subject
    }
}