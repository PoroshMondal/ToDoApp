package com.innovative.porosh.todoapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.innovative.porosh.todoapp.daos.ToDoDao
import com.innovative.porosh.todoapp.entities.ToDoModel

@Database(entities = [ToDoModel::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun getToDoDao(): ToDoDao

    companion object {
        private var toDoDatabase: ToDoDatabase? = null

        fun getDB(context: Context): ToDoDatabase {
            return toDoDatabase ?: synchronized(this) {
                val db = Room.databaseBuilder(context, ToDoDatabase::class.java,"ToDoDb")
                    .build()
                toDoDatabase = db
                db
            }
        }
    }

}