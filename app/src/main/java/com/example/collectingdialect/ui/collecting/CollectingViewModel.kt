package com.example.collectingdialect.ui.collecting

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Build
import android.view.View
import androidx.annotation.RawRes
import androidx.databinding.Bindable
import com.example.collectingdialect.BR
import com.example.collectingdialect.R
import com.example.collectingdialect.data.RecordManager
import com.example.collectingdialect.ui.BaseViewModel
import com.example.collectingdialect.ui.MainActivity
import com.example.collectingdialect.ui.MainActivity.Companion.showToast
import com.example.collectingdialect.ui.login.LoginViewModel
import java.io.File

open class CollectingViewModel: BaseViewModel() {
    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var mediaDirectory: File? = null

    var userName: String = ""
    var fileName: String = ""
        set(value) {
            field = value
            initializeMediaPlayer()
        }
    var isRecording: Boolean = false

    var currentSubject = ""

    var isRecordExist = false
        @Bindable get
        set(value) {
            if(field != value) {
                field = value
                notifyChange(BR.recordExist)
            }
        }

    init {
        val context = MainActivity.contextRequester?.invoke()
        if(context == null) {
            showToast("올바르지 않은 동작입니다. 앱을 완전히 종료 후 다시 시도해주세요")
        } else {
            mediaDirectory = context.filesDir
            userName = context.getSharedPreferences(LoginViewModel.PREFERENCE_USER, Context.MODE_PRIVATE).getString(LoginViewModel.KEY_ID, "") ?: ""
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

    private fun initializeMediaPlayer() {
        mediaPlayer = MediaPlayer().apply {
            isRecordExist = try {
                val file = File(mediaDirectory, "$fileName.mp4")
                setDataSource(file.absolutePath)
                prepare()
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    open fun onClickRecordButton(view: View) {
        onClickRecordButton(view) {}
    }

    fun onClickRecordButton(view: View, recordCallback: (() -> Unit)?) {
        if(isRecording) {
            isRecording = false
            RecordManager.onStopRecording()
            if(recordCallback == null) {
                view.setBackgroundResource(R.drawable.re_recording)
            } else {
                view.setBackgroundResource(R.drawable.start_recording)
            }

            mediaRecorder?.apply {
                stop()
                reset()
                release()
                RecordManager.updateRecordTime()
                isRecordExist = true
                recordCallback?.invoke()
            }
            this.mediaRecorder = null
        } else {
            val context = MainActivity.contextRequester?.invoke()
            if(context == null) {
                showToast("올바르지 않은 동작입니다. 앱을 완전히 종료 후 다시 시도해주세요")
            } else {
                isRecording = true
                val outputFile = File(mediaDirectory, "$fileName.mp4")
                if(outputFile.exists()) {
                    outputFile.delete()
                }
                RecordManager.onStartRecording()
                view.setBackgroundResource(R.drawable.recording)
                initializeMediaRecorder(context)
                mediaRecorder?.apply {
                    setOutputFile(outputFile.absolutePath)
                    prepare()
                    start()
                }
            }
        }
    }

    open fun onClickPlayButton(view: View) {
        try {
            if(mediaPlayer?.isPlaying == true) {
                return
            }
            initializeMediaPlayer()
            mediaPlayer?.start() ?: showToast("파일을 재생할 수 없습니다")
        } catch (e: Exception) {
            showToast("파일을 재생할 수 없습니다")
        }
    }

    open fun setSubject(subject: String) {
        currentSubject = subject
    }

    fun reRecordByFile(view: View, file: File) {
        /*if(!isRecording) {
            fileName = file.nameWithoutExtension
        }*/
        fileName = file.nameWithoutExtension
        onClickRecordButton(view, null)
    }

    fun playByFile(view: View, file: File) {
        fileName = file.nameWithoutExtension
        onClickPlayButton(view)
    }

    fun playScript(context: Context, @RawRes resId: Int) {
        try {
            if(mediaPlayer?.isPlaying == true) {
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
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}