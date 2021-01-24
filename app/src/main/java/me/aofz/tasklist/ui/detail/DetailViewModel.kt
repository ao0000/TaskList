package me.aofz.tasklist.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.tasklist.data.db.TaskEntity
import me.aofz.tasklist.data.repository.TaskRepository
import me.aofz.tasklist.model.Task

class DetailViewModel(private  val taskRepository : TaskRepository) : ViewModel() {

    fun deleteTask(task : Task){
        viewModelScope.launch {
            taskRepository.delete(task)
        }
    }
}