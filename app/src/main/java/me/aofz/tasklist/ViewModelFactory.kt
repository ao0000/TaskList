package me.aofz.tasklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.aofz.tasklist.addtask.AddViewModel
import me.aofz.tasklist.database.TaskRepository
import me.aofz.tasklist.detail.DetailViewModel
import me.aofz.tasklist.list.ListViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val taskRepository: TaskRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(
        modelClass: Class<T>
    ) = with(modelClass) {
        when {
            isAssignableFrom(AddViewModel::class.java) -> AddViewModel(taskRepository)
            isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(taskRepository)
            isAssignableFrom(ListViewModel::class.java) -> ListViewModel(taskRepository)
            else -> throw IllegalArgumentException("Unknown ViewModel class : $(modelClass.name)")
        }
    } as T
}