package me.aofz.tasklist.ui.taskdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.repository.TaskRepository

class DetailViewModel @ViewModelInject constructor(private val taskRepository: TaskRepository) :
    ViewModel() {

    private val _task = MutableLiveData<Task>()
    val task: LiveData<Task>
        get() = _task

    fun deleteTask(navigation: () -> Unit) {
        viewModelScope.launch {
            task.value?.let {
                taskRepository.delete(it)
                navigation()
            }
        }
    }

    fun setUpTask(receivedTask: Task) {
        _task.value = receivedTask
    }
}