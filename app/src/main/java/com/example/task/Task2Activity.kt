package com.example.task

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.task.databinding.ActivityMainBinding
import com.example.task.databinding.ActivityTask2Binding

class Task2Activity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTask2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgPlay.setOnClickListener()
        {
            playSound()
            binding.imgPlay.visibility = View.INVISIBLE
            binding.imgPause.visibility = View.VISIBLE
        }

        binding.imgPause.setOnClickListener()
        {
            pauseSound()
            binding.imgPlay.visibility = View.VISIBLE
            binding.imgPause.visibility = View.INVISIBLE
        }

    }

    fun playSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.deargod)
        mediaPlayer!!.start()
    }

    fun pauseSound() {
        mediaPlayer!!.pause()
    }

}