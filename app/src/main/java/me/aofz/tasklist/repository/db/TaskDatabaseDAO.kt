package me.aofz.tasklist.repository.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(vararg taskEntity: TaskEntity)

    @Query("SELECT * FROM task_table ORDER BY task_id ASC")
    fun observeTasks(): Flow<List<TaskEntity>>

    @Delete
    suspend fun deleteTask(vararg task: TaskEntity)

}