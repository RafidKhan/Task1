package com.example.task

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.widget.Toast

class SoundBGService : Service() {

    private var mediaPlayer2: MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        playSound()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        pauseSound()
        Log.d("funplay", "from service pause")
    }

    private fun playSound() {
        mediaPlayer2 = MediaPlayer.create(this, R.raw.deargod2)
        mediaPlayer2!!.start()
    }

    private fun pauseSound() {
        mediaPlayer2!!.pause()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}