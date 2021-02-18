package com.example.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.task1btn.setOnClickListener()
        {
            intent = Intent(applicationContext, Task1Activity::class.java)
            startActivity(intent)
        }

        binding.task2btn.setOnClickListener()
        {
            intent = Intent(applicationContext, Task2Activity::class.java)
            startActivity(intent)
        }

        binding.task3btn.setOnClickListener()
        {
            intent = Intent(applicationContext, Task3Activity::class.java)
            startActivity(intent)
        }
    }
}