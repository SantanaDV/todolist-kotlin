package com.proyect.todolistapp.utils

import androidx.room.TypeConverters
import java.time.LocalDate

class Converters {
    @TypeConverters
    fun localDateToString(value: LocalDate?): String? = value?.toString()

    @TypeConverters
    fun stringToLocalDate(value: String?): LocalDate? = LocalDate.parse(value)
}
