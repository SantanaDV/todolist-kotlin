package com.proyect.todolistapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.proyect.todolistapp.data.database.dao.TaskDao
import com.proyect.todolistapp.data.database.entity.TasksEntity
import com.proyect.todolistapp.utils.Converters

@Database(entities = [TasksEntity::class], version = 1, exportSchema = false)
@TypeConverters(value = [Converters::class])
abstract class TasksDatabase : RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
}
