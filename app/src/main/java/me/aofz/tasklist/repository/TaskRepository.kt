package me.aofz.tasklist.repository

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.aofz.tasklist.database.TaskDatabase
import me.aofz.tasklist.database.Task

class TaskRepository(context: Context) {

    private var database = TaskDatabase.getInstance(context).taskDatabaseDAO
    var allTask: LiveData<List<Task>> = database.getAllTask()

    companion object {
        private var instance: TaskRepository? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: TaskRepository(
                context.applicationContext
            ).also {
                instance = it
            }
        }
    }

    suspend fun insert(task: Task) {
        withContext(Dispatchers.IO) {
            database.insertTask(task)
            allTask = database.getAllTask()
        }
    }

    suspend fun delete(task: Task) {
        withContext(Dispatchers.IO) {
            database.deleteTask(task)
            allTask = database.getAllTask()
        }
    }

    suspend fun update(task: Task) {
        withContext(Dispatchers.IO) {
            database.updateTask(task)
        }
    }

}