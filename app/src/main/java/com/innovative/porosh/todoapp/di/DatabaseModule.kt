package com.innovative.porosh.todoapp.di

import android.content.Context
import com.innovative.porosh.todoapp.daos.ToDoDao
import com.innovative.porosh.todoapp.db.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideToDoDao(@ApplicationContext context: Context): ToDoDao{
        return ToDoDatabase.getDB(context).getToDoDao()
    }

}