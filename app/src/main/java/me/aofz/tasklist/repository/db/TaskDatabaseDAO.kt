package me.aofz.tasklist.repository.db

import androidx.paging.PagingSource
import androidx.room.*
import me.aofz.tasklist.model.TaskEntity

@Dao
interface TaskDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg taskEntity: TaskEntity)

    @Update
    suspend fun updateTask(vararg taskEntity: TaskEntity)

    @Query("SELECT * FROM task_table ORDER BY task_id ASC")
    fun getAllTask(): PagingSource<Int, TaskEntity>

    @Delete
    suspend fun deleteTask(vararg task: TaskEntity)

}