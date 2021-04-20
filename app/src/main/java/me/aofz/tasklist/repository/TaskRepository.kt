package me.aofz.tasklist.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.repository.db.TaskDatabaseDAO
import javax.inject.Inject
import javax.inject.Singleton

interface TaskRepository {

    suspend fun getTasks(): Flow<List<Task>>

    suspend fun insert(task: Task)

    suspend fun delete(task: Task)

    suspend fun update(task: Task)

}


@Singleton
class TaskRepositoryImpl @Inject constructor(private val database: TaskDatabaseDAO) :
    TaskRepository {

    override suspend fun getTasks(): Flow<List<Task>> {
        return database.observeTasks().map {
            it.map { taskEntity ->
                taskEntity.toTask()
            }
        }
    }

    override suspend fun insert(task: Task) {
        withContext(Dispatchers.IO) {
            database.insertTask(task.toEntity())
        }
    }

    override suspend fun delete(task: Task) {
        withContext(Dispatchers.IO) {
            database.deleteTask(task.toEntity())
        }
    }

    override suspend fun update(task: Task) {
        withContext(Dispatchers.IO) {
            database.updateTask(task.toEntity())
        }
    }

}