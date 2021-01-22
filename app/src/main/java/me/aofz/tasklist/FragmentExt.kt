package me.aofz.tasklist

import androidx.fragment.app.Fragment
import me.aofz.tasklist.database.TaskRepository

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = TaskRepository.getInstance(requireNotNull(activity).applicationContext)
    return ViewModelFactory(repository)
}