package com.jastzeonic.workmanagerdemo

import androidx.work.Worker
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.NotificationCompat


class DemoWorker : Worker() {
    override fun doWork(): WorkerResult {


        val channelID = "Demo Worker"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "sample Name"
            val description = "This is just for demo"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelID, name, importance)
            channel.description = description
            val notificationManager = applicationContext.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }




        Thread.sleep(5000)


        val mBuilder = NotificationCompat.Builder(applicationContext, channelID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)


        val notificationManager = NotificationManagerCompat.from(applicationContext)

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(0, mBuilder.build())

        return WorkerResult.SUCCESS


    }

}

