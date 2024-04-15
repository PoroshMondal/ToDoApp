package com.innovative.porosh.todoapp.repos

import android.content.Context
import androidx.lifecycle.LiveData
import com.innovative.porosh.todoapp.daos.ToDoDao
import com.innovative.porosh.todoapp.db.ToDoDatabase
import com.innovative.porosh.todoapp.entities.ToDoModel
import javax.inject.Inject

/*
* Creating the repository pattern
* to communicate with the ViewModel and local or cloud data source
* */
class ToDoRepository @Inject constructor(val toDoDao: ToDoDao) {

    suspend fun insertToDo(toDoModel: ToDoModel){
        toDoDao.addToDo(toDoModel)
    }

    fun getAllToDos(): LiveData<List<ToDoModel>>{
        return toDoDao.getAllToDos()
    }

    suspend fun updateToDo(toDoModel: ToDoModel) {
        toDoDao.updateToDo(toDoModel)
    }

    suspend fun deleteToDo(toDoModel: ToDoModel) {
        toDoDao.deleteToDo(toDoModel)
    }

}