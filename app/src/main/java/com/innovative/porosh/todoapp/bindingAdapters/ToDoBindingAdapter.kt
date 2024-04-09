package com.innovative.porosh.todoapp.bindingAdapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.innovative.porosh.todoapp.R
import com.innovative.porosh.todoapp.utils.Constants
import com.innovative.porosh.todoapp.utils.Functions

// These functions are top level functions

/*
* This "app: setPriorityIcon" string can be used in XML to set images base on priority condition
* */
@BindingAdapter("app:setPriorityIcon")
fun setPriorityIcon(imageView: ImageView, priority: String){
    val iconResource = when(priority){
        Constants.PRIORITY_LOW -> R.drawable.ic_blue_star_24
        Constants.PRIORITY_NORMAL -> R.drawable.ic_green_star_24
        else -> R.drawable.ic_red_star_24
    }
    imageView.setImageResource(iconResource)
}

@BindingAdapter("app:setFormattedDate")
fun setFormattedDate(tv: TextView, date: Long){
    tv.text = Functions.getFormattedDateTime(date,"dd/MM/yyyy")
}

@BindingAdapter("app:setFormattedTime")
fun setFormattedTime(tv: TextView, time: Long){
    tv.text = Functions.getFormattedDateTime(time,"hh:MM a")
}
