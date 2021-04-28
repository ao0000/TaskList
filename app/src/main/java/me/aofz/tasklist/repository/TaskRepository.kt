package me.aofz.tasklist.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.model.TaskEntity
import me.aofz.tasklist.repository.db.TaskDatabaseDAO
import javax.inject.Inject
import javax.inject.Singleton

interface TaskRepository {

    fun getTasks(): Flow<PagingData<Task>>

    suspend fun insert(task: Task)

    suspend fun delete(task: Task)

    suspend fun update(task: Task)

}


@Singleton
class TaskRepositoryImpl @Inject constructor(private val database: TaskDatabaseDAO) :
    TaskRepository {

    override fun getTasks(): Flow<PagingData<Task>> =
        Pager(config = PagingConfig(pageSize = 50)) { database.getAllTask() }
            .flow
            .map { pagingData: PagingData<TaskEntity> ->
                pagingData
                    .map { taskEntity: TaskEntity ->
                        taskEntity.toTask()
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