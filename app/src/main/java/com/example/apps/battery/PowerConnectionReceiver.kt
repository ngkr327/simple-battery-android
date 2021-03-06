package com.example.apps.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager

class PowerConnectionReceiver : BroadcastReceiver() {

    interface Listener {
        fun updateUI(value: String?)
    }

    private var listener: Listener? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        val status = when(intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1) {
            BatteryManager.BATTERY_STATUS_CHARGING -> "充電中"
            BatteryManager.BATTERY_STATUS_DISCHARGING -> "放電中"
            BatteryManager.BATTERY_STATUS_FULL -> "充電完了"
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> "未充電"
            BatteryManager.BATTERY_STATUS_UNKNOWN -> "UNKNOWN"
            else -> "不明"
        }
        listener?.updateUI(status)
    }

    fun setListener(listener: Listener?) {
        this.listener = listener
    }
}
