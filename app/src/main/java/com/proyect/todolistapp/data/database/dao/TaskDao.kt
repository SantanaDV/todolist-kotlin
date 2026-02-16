package com.proyect.todolistapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.proyect.todolistapp.data.database.entity.TasksEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TasksEntity)

    @Delete
    suspend fun delete(task: TasksEntity)

    @Query("SELECT * FROM tasks_table ORDER BY id DESC")
    fun getAll(): Flow<List<TasksEntity>>

    @Update
    suspend fun updateATask(task: TasksEntity)

    @Query("UPDATE tasks_table SET isCompleted = :isChecked WHERE id = :id ")
    suspend fun updateIsCompleted(
        id: Int,
        isChecked: Boolean,
    )
}
