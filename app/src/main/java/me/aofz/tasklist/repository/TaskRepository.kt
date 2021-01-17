package me.aofz.tasklist.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.aofz.tasklist.db.TaskDao
import me.aofz.tasklist.model.Task

class TaskRepository(private val database : TaskDao) {

    suspend fun insert(task : Task){
        withContext(Dispatchers.IO){
            database.insertTask(task)
        }
    }

    suspend fun delete(task: Task){
        withContext(Dispatchers.IO){
            database.deleteTask(task)
        }
    }

    suspend fun update(task: Task){
        withContext(Dispatchers.IO){
            database.updateTask(task)
        }
    }

    suspend fun getAll(task: Task){
        withContext(Dispatchers.IO){
            database.getAllTasks()
        }
    }
}