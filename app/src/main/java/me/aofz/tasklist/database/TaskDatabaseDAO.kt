package me.aofz.tasklist.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg task: Task)

    @Update
    suspend fun updateTask(vararg task: Task)

    @Query("SELECT * FROM task_table ORDER BY task_id ASC")
    fun observeTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM task_table WHERE task_id = :taskId  ")
    fun observeTaskById(taskId: Long): LiveData<Task>

    @Delete
    suspend fun deleteTask(vararg task: Task)

}