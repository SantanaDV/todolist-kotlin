package com.proyect.todolistapp.data.database.mapper

import com.proyect.todolistapp.data.database.entity.TasksEntity
import com.proyect.todolistapp.data.model.TasksModel

// De entidad a modelo
fun TasksEntity.toDomain() =
    TasksModel(
        id = id,
        title = title,
        description = description,
        startedDate = startedDate,
        finishDate = finishDate,
        isCompleted = isCompleted,
    )

// De modelo a entidad
fun TasksModel.toEntity() =
    TasksEntity(
        id = id,
        title = title,
        description = description,
        startedDate = startedDate,
        finishDate = finishDate,
        isCompleted = isCompleted,
    )
