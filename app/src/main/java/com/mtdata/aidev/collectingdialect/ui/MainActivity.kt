package com.mtdata.aidev.collectingdialect.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import com.mtdata.aidev.collectingdialect.R
import com.mtdata.aidev.collectingdialect.data.ContentData
import com.mtdata.aidev.collectingdialect.record.OnToolbarRecordTimeChangeListener
import com.mtdata.aidev.collectingdialect.record.RecordManager
import com.mtdata.aidev.collectingdialect.databinding.ActivityMainBinding
import com.mtdata.aidev.collectingdialect.ui.signin.SignInViewModel
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
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

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = sharedViewModel

        val preference = getSharedPreferences(SignInViewModel.PREFERENCE_COLLECTOR, Context.MODE_PRIVATE)
        val collectorId = preference.getString(SignInViewModel.KEY_ID, "")
        val collectorBirthYear = preference.getInt(SignInViewModel.KEY_BIRTH_YEAR, 9999)
        sharedViewModel.collectorId = collectorId
        sharedViewModel.collectorBirthYear = collectorBirthYear

        contextRequester = {this}
        val inputMethodManager = getSystemService(InputMethodManager::class.java)
        findViewById<View>(R.id.fragment_container_view).viewTreeObserver.addOnGlobalFocusChangeListener { oldFocus, newFocus ->
            if(newFocus is EditText && newFocus.inputType == InputType.TYPE_NULL) {
                inputMethodManager.hideSoftInputFromWindow(newFocus.windowToken, 0)
            }
        }
        setToolbar()
        if(checkSelfPermission(Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.RECORD_AUDIO), 1000)
        }
        ContentData.init(this)
    }

    override fun onResume() {
        super.onResume()
        val preference = getPreferences(Context.MODE_PRIVATE)
        val lastRecordCheckTimeMillis = preference.getLong(RecordManager.KEY_LAST_RECORD_CHECK_TIME_MILLIS, 0)
        val currentTimeMillis = System.currentTimeMillis()
        if(currentTimeMillis - lastRecordCheckTimeMillis > RecordManager.TIME_24_HOUR_MILLIS) {
            RecordManager.checkAndUploadRecord()
            preference.edit()
                .putLong(RecordManager.KEY_LAST_RECORD_CHECK_TIME_MILLIS, currentTimeMillis)
                .apply()
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
        RecordManager.onToolbarRecordTimeChangeListener = object:
            OnToolbarRecordTimeChangeListener {
            override fun onChangeRecordTime(timeString: String) {
                if(timeString.isNotEmpty()) {
                    toolbar.title = "녹음시간 $timeString / 25:00"
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
        val uploadDataMenu = navigationViewMenu.add("데이터 전송").apply {
            setOnMenuItemClickListener {
                MaterialAlertDialogBuilder(window.context)
                    .setMessage("저장된 모든 데이터를 서버로 전송 후 전송된 데이터를 삭제합니다")
                    .setPositiveButton("확인") { _, _ ->
                        navController.navigate(R.id.mainFragment)
                        navController.backQueue.clear()
                        RecordManager.uploadRecord()
                    }
                    .setNegativeButton("취소") { _, _ -> /*do nothing*/ }
                    .create()
                    .show()
                drawerLayout.close()
                true
            }
        }
        val logoutMenu = navigationViewMenu.add("로그아웃").apply {
            setOnMenuItemClickListener {
                val preference = getSharedPreferences(SignInViewModel.PREFERENCE_COLLECTOR, Context.MODE_PRIVATE)
                preference.edit().clear().apply()
                sharedViewModel.collectorId = null
                sharedViewModel.collectorBirthYear = null
                showToast("로그아웃 성공")
                loginCallback?.invoke()
                navController.navigate(R.id.mainFragment)
                navController.backQueue.clear()
                drawerLayout.close()
                true
            }
        }
        loginCallback = {
            val preference = getSharedPreferences(SignInViewModel.PREFERENCE_COLLECTOR, Context.MODE_PRIVATE)
            val isLoggedIn = preference.contains(SignInViewModel.KEY_ID)
            logoutMenu.isVisible = isLoggedIn
        }
        loginCallback?.invoke()
    }
}