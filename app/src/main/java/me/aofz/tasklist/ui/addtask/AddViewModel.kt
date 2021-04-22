package me.aofz.tasklist.ui.addtask

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.model.Title
import me.aofz.tasklist.repository.TaskRepository

class AddViewModel @ViewModelInject constructor(private val taskRepository: TaskRepository) :
    ViewModel() {

    // Two-way binding
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    private val _decideButtonClicked = MutableLiveData<Boolean>()
    val decideButtonClicked: LiveData<Boolean>
        get() = _decideButtonClicked

    fun addTask() {
        val currentDescription: String = description.value ?: ""
        val currentTitle: String = title.value ?: currentDescription
        if (currentTitle.isEmpty()) return
        
        val task = Task(
            title = Title(currentTitle),
            description = currentDescription
        )

        viewModelScope.launch {
            taskRepository.insert(task)
        }

        _decideButtonClicked.value = true
    }
}