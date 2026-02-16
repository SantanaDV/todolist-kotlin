package com.proyect.todolistapp.data.model

import java.time.LocalDate

data class TasksModel(
    val id: Int = 0,
    val title: String?,
    val description: String?,
    val startedDate: LocalDate?,
    val finishDate: LocalDate?,
    val isCompleted: Boolean = false,
) {
    constructor(
        title: String,
        description: String,
    ) : this(
        title = title,
        description = description,
        startedDate = @Suppress("ktlint:standard:max-line-length")
        LocalDate.now(),
        finishDate = LocalDate.now().plusDays(3),
        isCompleted = false,
    )
}
