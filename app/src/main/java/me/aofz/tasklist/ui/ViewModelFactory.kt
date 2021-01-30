package me.aofz.tasklist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.aofz.tasklist.ui.addtask.AddViewModel
import me.aofz.tasklist.data.repository.TaskRepository
import me.aofz.tasklist.ui.taskdetail.DetailViewModel
import me.aofz.tasklist.ui.list.ListViewModel
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