package com.proyect.todolistapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.proyect.todolistapp.data.model.Tasks

@Dao
interface TaskDao {
    @Insert
    suspend fun insertAll(vararg tasks: Tasks)

    @Insert
    suspend fun insertTask(task: Tasks)

    @Delete
    suspend fun delete(task: Tasks)

    @Query("SELECT * FROM tasks")
    suspend fun getAll(): List<Tasks>

    @Update
    suspend fun updateATask(task: Tasks)
}
