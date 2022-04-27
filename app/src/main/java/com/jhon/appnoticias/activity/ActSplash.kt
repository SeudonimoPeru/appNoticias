package com.jhon.appnoticias.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.jhon.appnoticias.R

class ActSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashScreen.setKeepOnScreenCondition { true }
        gotoMain()

    }

    private fun gotoMain() {
        val intentGotoMenu = Intent(applicationContext, ActMain::class.java);
        startActivity(intentGotoMenu)
        finish()
    }
}