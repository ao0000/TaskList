package me.aofz.tasklist.db

import androidx.room.*
import me.aofz.tasklist.model.Task

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg task: Task)

    @Update
    suspend fun updateTask(vararg task: Task)

    @Delete
    suspend fun deleteTask(vararg task: Task)

    @Query("select * from tasks")
    suspend fun getAllTasks(): List<Task>

}