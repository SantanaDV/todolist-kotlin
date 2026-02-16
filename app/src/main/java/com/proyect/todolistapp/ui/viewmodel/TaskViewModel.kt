package com.proyect.todolistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyect.todolistapp.data.database.repository.TasksRepository
import com.proyect.todolistapp.data.model.TasksModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel
    @Inject
    constructor(
        private val repository: TasksRepository,
    ) : ViewModel() {
        val tasks: StateFlow<List<TasksModel>> =
            repository
                .getAllTasks()
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5000),
                    initialValue = emptyList(),
                )

        fun addTask(
            title: String,
            description: String,
        ) {
            viewModelScope.launch {
                val task =
                    TasksModel(
                        title = title,
                        description = description,
                    )
                repository.insertTask(task)
            }
        }

        fun delete(task: TasksModel) {
            viewModelScope.launch {
                repository.delete(task)
            }
        }

        fun updateATask(task: TasksModel) {
            viewModelScope.launch {
                repository.updateATask(task)
            }
        }

        fun onTaskCheckedChange(
            task: TasksModel,
            isChecked: Boolean,
        ) {
            viewModelScope.launch {
                repository.updateIsCompleted(task.copy(isCompleted = isChecked))
            }
        }
    }
