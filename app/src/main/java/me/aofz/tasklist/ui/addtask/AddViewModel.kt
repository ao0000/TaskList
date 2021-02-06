package me.aofz.tasklist.ui.addtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.tasklist.repository.TaskRepository
import me.aofz.tasklist.model.Task

class AddViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    // Two-way binding
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    private val _decideButtonClicked = MutableLiveData<Boolean>()
    val decideButtonClicked: LiveData<Boolean>
        get() = _decideButtonClicked

    fun addTask() {
        val currentTitle = title.value ?: description.value ?: ""
        val currentDescription = description.value ?: ""
        if (currentTitle.isEmpty()) return

        val task = Task(
            title = currentTitle,
            description = currentDescription
        )
        viewModelScope.launch {
            taskRepository.insert(task)
        }

        _decideButtonClicked.value = true
    }
}