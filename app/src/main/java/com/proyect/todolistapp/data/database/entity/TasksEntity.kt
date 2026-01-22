package com.proyect.todolistapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity("tasks_table")
data class TasksEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title")val title: String?,
    @ColumnInfo(name = "description")val description: String?,
    @ColumnInfo(name = "startedDate")val startedDate: LocalDate?,
    @ColumnInfo(name = "finishDate")val finishDate: LocalDate?,
    @ColumnInfo(name = "isCompleted") val isCompleted: Boolean,
)
