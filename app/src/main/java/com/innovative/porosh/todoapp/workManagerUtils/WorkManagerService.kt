package com.innovative.porosh.todoapp.workManagerUtils

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class WorkManagerService(val context: Context) {
    fun schedule(name: String, delay: Long){
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
            .build()

        val request = OneTimeWorkRequestBuilder<NotificationWorker>()
            .addTag(name)
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            //.setConstraints(constraints)
            .build()

        WorkManager.getInstance(context).enqueue(request)
    }
}