package com.innovative.porosh.todoapp.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class TimePickerDialogFragment(val callback: (Long) -> Unit): DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(requireActivity(),this,hour, minute,false)
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(0,0,0, hour, minute)
        callback(calendar.timeInMillis)
    }

}