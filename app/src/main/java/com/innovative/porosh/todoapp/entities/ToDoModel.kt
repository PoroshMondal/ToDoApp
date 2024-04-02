package com.innovative.porosh.todoapp.entities

data class ToDoModel(
    var id: Long = 0,
    val name: String,
    val priority: String,
    val date: Long,
    val time: Long,
    var isCompleted: Boolean = false
)