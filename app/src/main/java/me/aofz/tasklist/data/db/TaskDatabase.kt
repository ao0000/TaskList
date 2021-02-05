package me.aofz.tasklist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDatabaseDAO(): TaskDatabaseDAO
}