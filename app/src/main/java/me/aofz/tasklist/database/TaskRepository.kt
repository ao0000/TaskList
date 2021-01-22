package me.aofz.tasklist.database

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepository(context: Context) {

    private var database = TaskDatabase.getInstance(context).taskDatabaseDAO
    var allTask: LiveData<List<Task>> = database.observeTasks()

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
            allTask = database.observeTasks()
        }
    }

    suspend fun delete(task: Task) {
        withContext(Dispatchers.IO) {
            database.deleteTask(task)
            allTask = database.observeTasks()
        }
    }

    suspend fun update(task: Task) {
        withContext(Dispatchers.IO) {
            database.updateTask(task)
        }
    }

}