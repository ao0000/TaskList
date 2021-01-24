package me.aofz.tasklist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(vararg taskEntity: TaskEntity)

    @Query("SELECT * FROM task_table ORDER BY task_id ASC")
    fun observeTasks(): LiveData<List<TaskEntity>>

    @Query("SELECT * FROM task_table WHERE task_id = :taskId")
    fun observeTaskById(taskId: Long): LiveData<TaskEntity>

    @Delete
    suspend fun deleteTask(vararg task: TaskEntity)

}