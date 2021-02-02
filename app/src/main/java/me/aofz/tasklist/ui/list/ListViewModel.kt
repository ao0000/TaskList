package me.aofz.tasklist.ui.list

import androidx.lifecycle.*
import me.aofz.tasklist.data.repository.TaskRepository
import me.aofz.tasklist.model.Task

class ListViewModel(taskRepository: TaskRepository) : ViewModel() {
    val allTask: LiveData<List<Task>> = taskRepository.getTasks()

    private val _addButtonClicked = MutableLiveData<Boolean>()
    val addButtonClicked: LiveData<Boolean>
        get() = _addButtonClicked

    fun navigateAddTask() {
        _addButtonClicked.value = true
        _addButtonClicked.value = null
    }
}