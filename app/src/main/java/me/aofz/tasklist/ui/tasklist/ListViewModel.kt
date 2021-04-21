package me.aofz.tasklist.ui.tasklist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.repository.TaskRepository

class ListViewModel @ViewModelInject constructor(private val taskRepository: TaskRepository) :
    ViewModel() {

    val allTask: LiveData<List<Task>> = taskRepository.getTasks().asLiveData()

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskRepository.delete(task)
        }
    }
}