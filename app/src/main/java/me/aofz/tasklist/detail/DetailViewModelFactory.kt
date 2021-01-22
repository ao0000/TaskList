package me.aofz.tasklist.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.aofz.tasklist.repository.TaskRepository

class DetailViewModelFactory(private val taskRepository: TaskRepository) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(taskRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}