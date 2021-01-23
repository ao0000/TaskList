package me.aofz.tasklist.ui.list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.database.TaskRepository

class ListViewModel(taskRepository: TaskRepository) : ViewModel() {
    val allTask:LiveData<List<Task>> = taskRepository.allTask

    fun navigateToDetailfragment(view: View, position: Int) {
        allTask.value
            ?.get(position)?.let { ListFragmentDirections.actionListFragmentToDetailFragment(it) }
            ?.also {Navigation.findNavController(view).navigate(it)}
    }
}