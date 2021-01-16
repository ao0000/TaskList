package me.aofz.tasklist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.aofz.tasklist.model.Task

@Database(entities = arrayOf(Task::class), version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}