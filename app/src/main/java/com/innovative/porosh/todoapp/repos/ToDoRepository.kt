package com.innovative.porosh.todoapp.repos

import android.content.Context
import androidx.lifecycle.LiveData
import com.innovative.porosh.todoapp.daos.ToDoDao
import com.innovative.porosh.todoapp.db.ToDoDatabase
import com.innovative.porosh.todoapp.entities.ToDoModel

/*
* Creating the repository pattern
* to communicate with the ViewModel and local or cloud data source
* */
class ToDoRepository(private val context: Context) {
    private val toDoDao: ToDoDao

    init {
        toDoDao = ToDoDatabase.getDB(context).getToDoDao()
    }

    fun insertToDo(toDoModel: ToDoModel){
        toDoDao.addToDo(toDoModel)
    }

    fun getAllToDos(): LiveData<List<ToDoModel>>{
        return toDoDao.getAllToDos()
    }

    fun updateToDo(toDoModel: ToDoModel) {
        toDoDao.updateToDo(toDoModel)
    }

    fun deleteToDo(toDoModel: ToDoModel) {
        toDoDao.deleteToDo(toDoModel)
    }

}