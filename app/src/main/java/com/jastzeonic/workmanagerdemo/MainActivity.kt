package com.jastzeonic.workmanagerdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WorkR

        var notifyWork = OneTimeWorkRequest.Builder(DemoWorker::class.java)
                .build()
        WorkManager.getInstance().enqueue(notifyWork)


        WorkManager.getInstance()
                .beginWith(compressReqeust)
                .then(uploadReqeust)
                .enqueue()


    }
}

class ImageCompressWorker : Worker()
class ImageUploadWorker : Worker()


