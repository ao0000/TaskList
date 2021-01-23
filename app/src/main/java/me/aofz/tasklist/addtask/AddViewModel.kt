package me.aofz.tasklist.addtask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.runBlocking
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.database.TaskRepository

class AddViewModel(private val taskRepository: TaskRepository) : ViewModel() {

    val title = MutableLiveData<String>()

    val description = MutableLiveData<String>()

    fun addTask() {
        val currentTitle = title.value ?: description.value ?: ""
        val currentDescription = description.value ?: ""
        val task = Task(title = currentTitle, description = currentDescription)
        runBlocking {
            taskRepository.insert(task)
        }
    }
}