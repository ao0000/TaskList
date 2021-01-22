package me.aofz.tasklist.list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.coroutines.launch
import me.aofz.tasklist.database.Task
import me.aofz.tasklist.repository.TaskRepository

class ListViewModel(taskRepository: TaskRepository) : ViewModel() {
    val allTask:LiveData<List<Task>> = taskRepository.allTask

    fun navigateToDetailfragment(view: View, position: Int) {
        allTask.value
            ?.get(position)?.let { ListFragmentDirections.actionListFragmentToDetailFragment(it) }
            ?.also {Navigation.findNavController(view).navigate(it)}
    }
}