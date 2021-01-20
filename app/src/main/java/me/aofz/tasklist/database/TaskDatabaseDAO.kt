package me.aofz.tasklist.database

import androidx.room.*

@Dao
interface TaskDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(vararg task: Task)

    @Update
    suspend fun updateTask(vararg task: Task)

    @Delete
    suspend fun deleteTask(vararg task: Task)

    @Query("SELECT * FROM task_table ORDER BY id DESC")
    fun getAllTask(): List<Task>

}