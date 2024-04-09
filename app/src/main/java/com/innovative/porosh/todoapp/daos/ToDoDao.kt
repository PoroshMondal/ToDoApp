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
    suspend fun addToDo(toDoModel: ToDoModel)

    @Update
    suspend fun updateToDo(toDoModel: ToDoModel)

    @Delete
    suspend fun deleteToDo(toDoModel: ToDoModel)

    @Query("SELECT * FROM tbl_to_do ORDER BY id desc")
    fun getAllToDos(): LiveData<List<ToDoModel>>

    /*@Query("SELECT * FROM tbl_to_do ORDER BY id desc")
    fun getAllToDos(): List<ToDoModel>*/

}