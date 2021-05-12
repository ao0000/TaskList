package me.aofz.tasklist.model

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TaskTest {

    private lateinit var task: Task

    @Before
    fun setUp() {
        task = Task(1, Title("sampleTitle"), Description("sampleDescription"))
    }

    @Test
    fun test_default_values() {
        val defaultTask = Task(2, Title("title2"), Description("description2"))
        assertEquals(2, defaultTask.id)
        assertEquals(Title("title2"), defaultTask.title)
        assertEquals(Description("description2"), defaultTask.description)
    }

    @Test
    fun toEntity() {
        val taskEntity: TaskEntity = task.toEntity()

        assertEquals(
            TaskEntity(
                task.id,
                task.title.toString(),
                task.description.toString()
            ),
            taskEntity
        )
    }
}