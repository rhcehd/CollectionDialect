package com.example.collectingdialect.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.example.collectingdialect.R
import com.example.collectingdialect.data.RecordTimeUpdateCallback
import com.example.collectingdialect.data.RecordTimeUpdater
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    companion object {
        var contextRequester: (() -> Context)? = null
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
        setToolbar()
        if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.RECORD_AUDIO), 1000)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // add permission route
    }

    private fun setToolbar() {
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.isTitleCentered = true
        RecordTimeUpdater.recordTimeUpdateCallback = object: RecordTimeUpdateCallback {
            override fun onUpdateRecordTime(timeString: String) {
                toolbar.title = "녹음시간 : $timeString"
            }
        }
        RecordTimeUpdater.updateRecordTime()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        toolbar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        val navigationViewMenu = navigationView.menu
        navigationViewMenu.add("홈").apply {
            setOnMenuItemClickListener {
                drawerLayout.close()
                true
            }
        }
        navigationViewMenu.add("로그인").apply {
            setOnMenuItemClickListener {
                drawerLayout.close()
                true
            }
        }

        toolbar.menu.add("setting").apply {
            setIcon(R.drawable.ic_baseline_settings_24)
            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        }
    }
}