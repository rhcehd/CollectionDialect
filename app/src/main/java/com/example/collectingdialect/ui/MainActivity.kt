package com.example.collectingdialect.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import com.example.collectingdialect.R
import com.example.collectingdialect.data.ContentData
import com.example.collectingdialect.data.RecordTimeUpdateCallback
import com.example.collectingdialect.data.RecordTimeManager
import com.example.collectingdialect.remote.ApiManager
import com.example.collectingdialect.ui.login.LoginViewModel
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

        var loginCallback: (() -> Unit)? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contextRequester = {this}
        setToolbar()
        if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.RECORD_AUDIO), 1000)
        }
        //ContentData.init(this)
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
        val userPreference = getSharedPreferences(LoginViewModel.PREFERENCE_USER, Context.MODE_PRIVATE)
        RecordTimeManager.recordTimeUpdateCallback = object: RecordTimeUpdateCallback {
            override fun onUpdateRecordTime(timeString: String) {
                val currentUser = userPreference.getString(LoginViewModel.KEY_ID, "") ?: ""
                if(currentUser.isNotEmpty()) {
                    toolbar.title = "녹음시간 : $timeString"
                } else {
                    toolbar.title = ""
                }
            }
        }

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        toolbar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        val navigationViewMenu = navigationView.menu
        val homeMenu = navigationViewMenu.add("홈").apply {
            setOnMenuItemClickListener {
                navController.navigate(R.id.mainFragment)
                navController.backQueue.clear()
                drawerLayout.close()
                true
            }
        }
        val loginMenu = navigationViewMenu.add("로그인").apply {
            setOnMenuItemClickListener {
                navController.navigate(R.id.loginFragment)
                drawerLayout.close()
                true
            }
        }
        val logoutMenu = navigationViewMenu.add("로그아웃").apply {
            setOnMenuItemClickListener {
                val preference = getSharedPreferences(LoginViewModel.PREFERENCE_USER, Context.MODE_PRIVATE)
                preference.edit().clear().apply()
                showToast("로그아웃 성공")
                loginCallback?.invoke()
                navController.navigate(R.id.mainFragment)
                navController.backQueue.clear()
                drawerLayout.close()
                true
            }
        }
        loginCallback = {
            val preference = getSharedPreferences(LoginViewModel.PREFERENCE_USER, Context.MODE_PRIVATE)
            val isLoggedIn = preference.contains(LoginViewModel.KEY_ID)
            loginMenu.isVisible = !isLoggedIn
            logoutMenu.isVisible = isLoggedIn
            RecordTimeManager.updateRecordTime()
        }
        loginCallback?.invoke()

        toolbar.menu.add("setting").apply {
            setIcon(R.drawable.ic_baseline_settings_24)
            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
            setOnMenuItemClickListener {
                val isValidRecordTime = RecordTimeManager.validateRecordTime()
                if(isValidRecordTime) {
                    ApiManager.sendRecordData(this@MainActivity, {}, {})
                } else {
                    //do nothing
                }
                true
            }
        }
    }
}