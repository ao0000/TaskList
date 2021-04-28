package me.aofz.tasklist.ui.tasklist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.repository.TaskRepository

class ListViewModel @ViewModelInject constructor(private val taskRepository: TaskRepository) :
    ViewModel() {

    val allTask: Flow<PagingData<Task>> = taskRepository.getTasks().cachedIn(viewModelScope)

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskRepository.delete(task)
        }
    }
}