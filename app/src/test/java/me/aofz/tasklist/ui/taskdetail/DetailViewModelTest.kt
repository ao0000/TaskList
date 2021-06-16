package me.aofz.tasklist.ui.taskdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import me.aofz.tasklist.model.Description
import me.aofz.tasklist.model.Task
import me.aofz.tasklist.model.Title
import me.aofz.tasklist.repository.FakeTaskRepository
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel

    private lateinit var taskRepository: FakeTaskRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun detailViewModelSetUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)

        taskRepository = FakeTaskRepository()
        val task1 = Task(1, Title("title1"), Description("description1"))
        val task2 = Task(2, Title("title2"), Description("description2"))
        taskRepository.add(task1, task2)

        detailViewModel = DetailViewModel(taskRepository)
    }

    @After
    fun detailViewModelTearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun setUpTask_receivedTaskIsNotNull() {
        val task1 = Task(1, Title("title1"), Description("description1"))
        detailViewModel.setUpTask(task1)
        val receivedTask = detailViewModel.task.value ?: null
        assertThat(receivedTask?.id).isNotNull()
    }

    @Test
    fun setUpTask_receivedTaskIsSet() {
        val task1 = Task(1, Title("title1"), Description("description1"))
        detailViewModel.setUpTask(task1)
        val receivedTask = detailViewModel.task.value ?: null
        assertThat(receivedTask?.id).isEqualTo(task1.id)
    }
}