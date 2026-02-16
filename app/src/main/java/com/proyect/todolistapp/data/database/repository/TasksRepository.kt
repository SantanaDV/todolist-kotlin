package com.proyect.todolistapp.data.database.repository

import com.proyect.todolistapp.data.database.dao.TaskDao
import com.proyect.todolistapp.data.database.mapper.toDomain
import com.proyect.todolistapp.data.database.mapper.toEntity
import com.proyect.todolistapp.data.model.TasksModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TasksRepository
    @Inject
    constructor(
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

        suspend fun updateATask(task: TasksModel) = taskDao.updateATask(task.toEntity())

        suspend fun updateIsCompleted(task: TasksModel) = taskDao.updateIsCompleted(task.id)
    }
