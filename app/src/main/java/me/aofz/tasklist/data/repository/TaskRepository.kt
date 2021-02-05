package me.aofz.tasklist.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import me.aofz.tasklist.data.db.TaskDatabaseDAO
import me.aofz.tasklist.model.Task

class TaskRepository(private val database: TaskDatabaseDAO) {

    fun getTasks(): Flow<List<Task>> {
        return database.observeTasks().map {
            it.map { taskEntity ->
                taskEntity.toTask()
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