package me.aofz.tasklist.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.aofz.tasklist.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDatabaseDAO(): TaskDatabaseDAO
}