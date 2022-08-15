package com.syoon.shoppi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//API 30 이하 버전 Splash screen
class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}