package me.aofz.tasklist.ui.addtask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.tasklist.data.repository.TaskRepository
import me.aofz.tasklist.model.Task

class AddViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    fun addTask() {
        val currentTitle = title.value ?: description.value ?: ""
        val currentDescription = description.value ?: ""
        val task = Task(
            id = 0,
            title = currentTitle,
            description = currentDescription
        )
        viewModelScope.launch {
            taskRepository.insert(task)
        }
    }
}