package me.aofz.tasklist.add

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.repository.TaskRepository

class AddViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    fun addTask(task: Task){
        runBlocking {
            Log.d("AddViewModel", " will insert")
            taskRepository.insert(task)

            Log.d("AddViewModel", " end insert")
        }
    }
}