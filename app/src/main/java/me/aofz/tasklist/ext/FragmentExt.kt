package me.aofz.tasklist.ext

import androidx.fragment.app.Fragment
import me.aofz.tasklist.ui.ViewModelFactory
import me.aofz.tasklist.data.repository.TaskRepository

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = TaskRepository.getInstance(requireNotNull(activity).applicationContext)
    return ViewModelFactory(repository)
}