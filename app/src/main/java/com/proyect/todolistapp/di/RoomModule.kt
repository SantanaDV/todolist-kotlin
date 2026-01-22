package com.proyect.todolistapp.di

import android.content.Context
import androidx.room.Room
import com.proyect.todolistapp.data.database.TasksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val TASK_DATABASE_NAME = "task_database"

    @Singleton
    @Provides
    fun provideRoom(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(context, TasksDatabase::class.java, TASK_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideTasksDao(db: TasksDatabase) = db.getTaskDao()
}
