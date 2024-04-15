package com.innovative.porosh.todoapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.innovative.porosh.todoapp.entities.ToDoModel
import com.innovative.porosh.todoapp.repos.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* We will extend AndroidViewModel instead of ViewModel
* if we need any view reference or context
* Application is child of a Context
*
* If we use Hilt Dependency Injection(DI) then
* we will extend ViewModel instead of AndroidViewModel
* And we will declare the repository object in the class constructor as
* it will provided by the Hilt library (by using @Inject constructor)
* */

@HiltViewModel
class ToDoViewModel @Inject constructor(val repository: ToDoRepository): ViewModel() {

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