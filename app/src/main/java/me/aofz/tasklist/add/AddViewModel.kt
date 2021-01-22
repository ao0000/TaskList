package me.aofz.tasklist.add

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.runBlocking
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.database.TaskRepository

class AddViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    fun addTask(task: Task){
        runBlocking {
            Log.d("AddViewModel", " will insert")
            taskRepository.insert(task)

            Log.d("AddViewModel", " end insert")
        }
    }
}