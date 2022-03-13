package com.example.collectingdialect.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.collectingdialect.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    companion object {
        private var contextRequester: (() -> Context)? = null
        fun showToast(msg: String) {
            val context = contextRequester?.invoke()
            if(context != null) {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contextRequester = {this}
    }
}