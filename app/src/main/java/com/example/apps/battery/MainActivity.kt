package com.example.apps.battery

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        this.applicationContext.registerReceiver(PowerConnectionReceiver(), ifilter)
    }
}
