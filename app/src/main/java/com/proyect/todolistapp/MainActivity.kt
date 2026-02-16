package com.proyect.todolistapp

import android.R.attr.process
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.proyect.todolistapp.data.database.TasksDatabase
import com.proyect.todolistapp.data.database.repository.TasksRepository
import com.proyect.todolistapp.data.model.TasksModel
import com.proyect.todolistapp.databinding.ActivityMainBinding
import com.proyect.todolistapp.di.RoomModule
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var tasksRepository: TasksRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Codigo de prueba de la bd

        val task = TasksModel("Prueba", "Descripcion Prueba")
        lifecycleScope.launch {
            tasksRepository.insertTask(task)
        }
        val tasks = tasksRepository.getAllTasks()

        lifecycleScope.launch {
            var t = TasksModel("s", "d")
            val taskList = tasks.first()
            for (x in taskList) {
                if (x.isCompleted == false) {
                    t = x.copy(isCompleted = true)
                }
            }
            tasksRepository.updateIsCompleted(t)
        }

        // binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(binding.root)
    }
}
