package com.proyect.todolistapp.data.repository

import com.proyect.todolistapp.data.dao.TaskDao
import com.proyect.todolistapp.data.model.Tasks
import kotlinx.coroutines.flow.Flow

class TasksRepository(
    private val taskDao: TaskDao,
) {
    suspend fun insertAll(vararg tasks: Tasks) = taskDao.insertAll(*tasks)

    suspend fun insertTask(task: Tasks) = taskDao.insertTask(task)

    suspend fun delete(task: Tasks) = taskDao.delete(task)

    suspend fun getAllTasks(): Flow<List<Tasks>> = taskDao.getAll()

    suspend fun updateATask(task: Tasks) = taskDao.updateATask(task)
}
