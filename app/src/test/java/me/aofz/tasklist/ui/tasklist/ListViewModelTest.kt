package me.aofz.tasklist.ui.tasklist

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import me.aofz.tasklist.model.Description
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.model.Title
import me.aofz.tasklist.repository.FakeTestTaskRepository
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ListViewModelTest {

    private lateinit var listViewModel: ListViewModel

    private lateinit var taskRepository: FakeTestTaskRepository

    @Before
    fun listViewModelSetUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)

        taskRepository = FakeTestTaskRepository()
        val task1 = Task(1, Title("title1"), Description("description1"))
        val task2 = Task(2, Title("title2"), Description("description2"))
        val task3 = Task(3, Title("title3"), Description("description3"))
        taskRepository.add(task1, task2, task3)

        listViewModel = ListViewModel(taskRepository)
    }

    @After
    fun listViewModelTearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun deleteTask_notContainTaskDeleted() = runBlocking {
        // When the task delete
        val task1 = Task(1, Title("title1"), Description("description1"))
        listViewModel.deleteTask(task1)

        // Then the task is deleted
        val remainTaskList = taskRepository.getTaskList()
        assertThat(remainTaskList.contains(task1)).isFalse()
    }

    @Test
    fun deleteTask_ContainAnotherTaskDeleted() = runBlocking {
        // When other tasks are deleted
        val task1 = Task(1, Title("title1"), Description("description1"))
        val task2 = Task(2, Title("title2"), Description("description2"))
        listViewModel.deleteTask(task1)
        listViewModel.deleteTask(task2)

        // Then the task is not deleted
        val remainTaskList = taskRepository.getTaskList()
        val task3 = Task(3, Title("title3"), Description("description3"))
        assertThat(remainTaskList.contains(task3)).isTrue()
    }

}