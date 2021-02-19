package com.example.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task.databinding.ActivityMainBinding
import com.example.task.databinding.ActivityTask2BaseBinding

class Task2BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTask2BaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnForeground.setOnClickListener()
        {
            intent = Intent(applicationContext, Task2Activity::class.java)
            startActivity(intent)
        }

        binding.btnBackgrond.setOnClickListener()
        {
            intent = Intent(applicationContext, Task2BackgroundActivity::class.java)
            startActivity(intent)
        }
    }
}