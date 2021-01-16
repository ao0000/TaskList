package me.aofz.tasklist.db

import androidx.room.*
import me.aofz.tasklist.model.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(vararg task: Task)

    @Update
    fun updateTask(vararg task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): List<Task>

    @Query("SELECT * FROM tasks where id = :id")
    fun getTask(id: Long): Task

    @Delete
    fun deleteTask(vararg task: Task)

}