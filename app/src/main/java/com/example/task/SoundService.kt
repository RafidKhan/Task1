package com.example.task

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi

class SoundService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForeground()

        }

        return START_STICKY
    }

   private fun playSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.deargod)
        mediaPlayer!!.start()
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                1.toString(), "ForegroundNotification", NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(notificationChannel)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun startForeground() {
        playSound()

        val pendingIntent: PendingIntent =
            Intent(this, Task2Activity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(this, 0, notificationIntent, 0)
            }

        val notification: Notification = Notification.Builder(this, 1.toString())
            .setContentTitle("Music Playing")
            .setContentText("Enjoy Your Music")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}