package me.aofz.tasklist.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.database.TaskRepository

class DetailViewModel(private  val taskRepository : TaskRepository) : ViewModel() {

    fun deleteTask(task : Task){
        viewModelScope.launch {
            taskRepository.delete(task)
        }
    }
}