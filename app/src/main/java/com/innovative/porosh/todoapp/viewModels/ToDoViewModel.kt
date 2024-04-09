package com.innovative.porosh.todoapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.innovative.porosh.todoapp.entities.ToDoModel
import com.innovative.porosh.todoapp.repos.ToDoRepository
import kotlinx.coroutines.launch

/*
* We will extend AndroidViewModel instead of ViewModel
* if we need any view reference or context
* Application is child of a Context
* */
class ToDoViewModel(application: Application): AndroidViewModel(application) {

    private val repository: ToDoRepository

    init {
        repository = ToDoRepository(application)
    }

    fun insertToDo(toDoModel: ToDoModel){
        viewModelScope.launch {
            repository.insertToDo(toDoModel)
        }
    }

    fun fetchAllToDos(): LiveData<List<ToDoModel>>{
        return repository.getAllToDos()
    }

    fun updateToDo(toDoModel: ToDoModel) {
        // to update isCompleted value of current ToDoModel
        //!toDoModel.isCompleted it changes the previous value
        toDoModel.isCompleted = !toDoModel.isCompleted
        viewModelScope.launch {
            repository.updateToDo(toDoModel)
        }
    }

    fun deleteToDo(toDoModel: ToDoModel) {
        viewModelScope.launch {
            repository.deleteToDo(toDoModel)
        }
    }

}