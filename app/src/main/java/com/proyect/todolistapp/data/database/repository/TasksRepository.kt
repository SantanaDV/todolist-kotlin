package com.proyect.todolistapp.data.database.repository

import com.proyect.todolistapp.data.database.dao.TaskDao
import com.proyect.todolistapp.data.database.entity.TasksEntity
import com.proyect.todolistapp.data.database.mapper.toDomain
import com.proyect.todolistapp.data.database.mapper.toEntity
import com.proyect.todolistapp.data.model.TasksModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TasksRepository(
    private val taskDao: TaskDao,
) {
    suspend fun insertTask(task: TasksModel) = taskDao.insertTask(task.toEntity())

    suspend fun delete(task: TasksModel) = taskDao.delete(task.toEntity())

    fun getAllTasks(): Flow<List<TasksModel>> =
        taskDao.getAll().map { list ->
            list.map {
                it.toDomain()
            }
        }

    fun updateATask(task: TasksModel) = taskDao.updateATask(task.toEntity())
}
