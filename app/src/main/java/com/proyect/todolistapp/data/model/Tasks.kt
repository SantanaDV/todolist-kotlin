package com.proyect.todolistapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity("tasks")
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val description: String?,
    val startedDate: LocalDate?,
    val finishDate: LocalDate?,
) 
