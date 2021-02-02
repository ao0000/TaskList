package me.aofz.tasklist.ui.taskdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.tasklist.data.repository.TaskRepository
import me.aofz.tasklist.model.Task

class DetailViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    private val _task = MutableLiveData<Task>()
    val task: LiveData<Task>
        get() = _task

    private val _deleteButtonClicked = MutableLiveData<Boolean>()
    val deleteButtonClicked: LiveData<Boolean>
        get() = _deleteButtonClicked

    fun deleteTask() {
        viewModelScope.launch {
            task.value?.let {
                taskRepository.delete(it)
                _deleteButtonClicked.value = true
            }
        }
    }

    fun setUpTask(receivedTask: Task) {
        _task.value = receivedTask
    }
}