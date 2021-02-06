package me.aofz.tasklist.ui.tasklist

import androidx.lifecycle.*
import me.aofz.tasklist.repository.TaskRepository
import me.aofz.tasklist.model.Task

class ListViewModel(taskRepository: TaskRepository) : ViewModel() {
    val allTask: LiveData<List<Task>> = taskRepository.getTasks().asLiveData()

    private val _addButtonClicked = MutableLiveData<Boolean>()
    val addButtonClicked: LiveData<Boolean>
        get() = _addButtonClicked

    fun navigateAddTask() {
        _addButtonClicked.value = true
        _addButtonClicked.value = null
    }
}