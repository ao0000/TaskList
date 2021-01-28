package me.aofz.tasklist.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import me.aofz.tasklist.data.repository.TaskRepository
import me.aofz.tasklist.model.Task

class ListViewModel(taskRepository: TaskRepository) : ViewModel() {
    val allTask: LiveData<List<Task>> = taskRepository.getTasks()
}