package com.innovative.porosh.todoapp.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.innovative.porosh.todoapp.entities.ToDoModel

@Dao
interface ToDoDao {

    @Insert
    fun addToDo(toDoModel: ToDoModel)

    @Update
    fun updateToDo(toDoModel: ToDoModel)

    @Delete
    fun deleteToDo(toDoModel: ToDoModel)

    @Query("SELECT * FROM tbl_to_do ORDER BY id desc")
    fun getAllToDos(): LiveData<List<ToDoModel>>

    /*@Query("SELECT * FROM tbl_to_do ORDER BY id desc")
    fun getAllToDos(): List<ToDoModel>*/

}