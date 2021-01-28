package me.aofz.tasklist.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.aofz.tasklist.data.db.TaskDatabase
import me.aofz.tasklist.data.db.TaskEntity
import me.aofz.tasklist.model.Task

class TaskRepository(context: Context) {

    private var database = TaskDatabase.getInstance(context).taskDatabaseDAO

    companion object {
        private var instance: TaskRepository? = null

        fun getInstance(context: Context) = instance
            ?: synchronized(this) {
                instance
                    ?: TaskRepository(
                        context.applicationContext
                    ).also {
                        instance = it
                    }
            }
    }

    fun getTasks(): LiveData<List<Task>> {
        return Transformations.map(database.observeTasks()) {
            it?.map { entity ->
                entity.toTask()
            }
        }
    }

    suspend fun insert(task: Task) {
        withContext(Dispatchers.IO) {
            database.insertTask(task.toEntity())
        }
    }

    suspend fun delete(task: Task) {
        withContext(Dispatchers.IO) {
            database.deleteTask(task.toEntity())
        }
    }

    suspend fun update(task: Task) {
        withContext(Dispatchers.IO) {
            database.updateTask(task.toEntity())
        }
    }

}