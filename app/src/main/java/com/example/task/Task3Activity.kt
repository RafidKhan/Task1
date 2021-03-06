package com.example.task

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.task.databinding.ActivityMainBinding
import com.example.task.databinding.ActivityTask3Binding

class Task3Activity : AppCompatActivity() {

    lateinit var receiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTask3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if(intent?.action == Intent.ACTION_POWER_CONNECTED)
                {
                    binding.actionTV.setText(intent?.action)
                    Toast.makeText(context, "Charger Connected", Toast.LENGTH_SHORT).show()
                }
                else if(intent?.action == Intent.ACTION_POWER_DISCONNECTED)
                {
                    binding.actionTV.setText(intent?.action)
                    Toast.makeText(context, "Charger Disconnected", Toast.LENGTH_SHORT).show()
                }
            }
        }
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        super.onDestroy()
    }
}