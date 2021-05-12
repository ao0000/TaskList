package me.aofz.tasklist.model

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TaskEntityTest {

    private lateinit var taskEntity: TaskEntity

    @Before
    fun setUp() {
        taskEntity = TaskEntity(1, "title", "description")
    }

    @Test
    fun test_default_values() {
        val defaultTaskEntity = TaskEntity(2, "title2", "description2")
        assertEquals(2, defaultTaskEntity.id)
        assertEquals("title2", defaultTaskEntity.title)
        assertEquals("description2", defaultTaskEntity.description)
    }

    @Test
    fun test_toTask() {
        val task: Task = taskEntity.toTask()
        assertEquals(
            Task(
                taskEntity.id,
                Title(taskEntity.title),
                Description(taskEntity.description)
            ),
            task
        )
    }
}