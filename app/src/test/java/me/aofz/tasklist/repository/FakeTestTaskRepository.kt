package me.aofz.tasklist.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.aofz.tasklist.model.Task

class FakeTestTaskRepository : TaskRepository {

    var tasksData: LinkedHashMap<String, Task> = LinkedHashMap()

    override fun getTasks(): Flow<PagingData<Task>> {
        return flowOf(PagingData.from(tasksData.values.toList()))
    }

    override suspend fun insert(task: Task) {
        tasksData[task.id.toString()] = task
    }

    override suspend fun delete(task: Task) {
        tasksData.remove(task.id.toString())
    }

    override suspend fun update(task: Task) {
        tasksData[task.id.toString()] = task
    }

}