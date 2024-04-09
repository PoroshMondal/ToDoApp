package com.innovative.porosh.todoapp.workManagerUtils

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(val context: Context, params: WorkerParameters): Worker(context, params) {

    override fun doWork(): Result {
        sendNotification(context)
        return Result.success()
    }

    private fun sendNotification(context: Context){

    }

}