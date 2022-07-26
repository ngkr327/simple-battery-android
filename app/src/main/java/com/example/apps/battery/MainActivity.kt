package com.example.apps.battery

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), PowerConnectionReceiver.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ifilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val receiver = PowerConnectionReceiver()
        receiver.setListener(this)
        this.applicationContext.registerReceiver(receiver, ifilter)
    }

    override fun updateUI(value: String?) {
        val textView: TextView = findViewById(R.id.text_view)
        textView.text = value
    }
}
