package me.aofz.tasklist.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import me.aofz.tasklist.model.Task

class FakeTaskRepository : TaskRepository {

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

    fun getTaskList(): List<Task> {
        return tasksData.values.toList()
    }

    fun add(vararg tasks: Task) {
        for (task in tasks) {
            tasksData[task.id.toString()] = task
        }
    }

}