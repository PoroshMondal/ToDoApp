package com.innovative.porosh.todoapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Functions {
    companion object {
        fun getFormattedDateTime(millis: Long, format: String): String {
            return SimpleDateFormat(format, Locale.getDefault()).format(Date(millis))
        }
    }
}