package com.proyect.todolistapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity("tasks")
data class TasksEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val description: String?,
    val startedDate: LocalDate?,
    val finishDate: LocalDate?,
    val isCompleted: Boolean,
)
