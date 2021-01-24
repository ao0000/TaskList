package me.aofz.tasklist.ui.list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import me.aofz.tasklist.data.db.TaskEntity
import me.aofz.tasklist.data.repository.TaskRepository

class ListViewModel(taskRepository: TaskRepository) : ViewModel() {
    val allTask:LiveData<List<TaskEntity>> = taskRepository.allTask

    fun navigateToDetailFragment(view: View, position: Int) {
        allTask.value
            ?.get(position)?.let { ListFragmentDirections.actionListFragmentToDetailFragment(it.toTask()) }
            ?.also {Navigation.findNavController(view).navigate(it)}
    }
}