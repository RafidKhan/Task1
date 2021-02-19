package com.example.task

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.task.databinding.ActivityTask2BackgroundBinding
import com.example.task.databinding.ActivityTask3Binding

class Task2BackgroundActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTask2BackgroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, SoundBGService::class.java)

        binding.btnPlay.setOnClickListener()
        {
            startService(intent)
            //Log.d("funplay", "from class play")
        }

        binding.btnPause.setOnClickListener()
        {
            stopService(intent)
            //Log.d("funplay", "from class pause")
        }

    }


}