package com.proyect.todolistapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.proyect.todolistapp.data.database.entity.TasksEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: TasksEntity)

    @Delete
    suspend fun delete(task: TasksEntity)

    @Query("SELECT * FROM tasks")
    fun getAll(): Flow<List<TasksEntity>>

    @Update
    fun updateATask(task: TasksEntity)
}
