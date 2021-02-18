package com.example.task

import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.task.databinding.ActivityTask2Binding

open class Task2Activity : AppCompatActivity() {

    //private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTask2Binding.inflate(layoutInflater)
        setContentView(binding.root)


            val intent = Intent(this, SoundService::class.java)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent)
            } else {
                startService(intent)
            }

        /*binding.imgPlay.setOnClickListener()
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

         */

    }


/*
    fun playSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.deargod)
        mediaPlayer!!.start()
    }

    fun pauseSound() {
        mediaPlayer!!.pause()
    }

 */

}