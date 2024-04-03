package com.innovative.porosh.todoapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_to_do")
data class ToDoModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    val name: String,
    val priority: String,
    val date: Long,
    val time: Long,

    @ColumnInfo(name="completed")
    var isCompleted: Boolean = false
)