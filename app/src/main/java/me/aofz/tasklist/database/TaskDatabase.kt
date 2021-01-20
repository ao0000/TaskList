package me.aofz.tasklist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDatabaseDAO: TaskDatabaseDAO

    companion object {
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                TaskDatabase::class.java,
                "task_database"
            )
                .fallbackToDestructiveMigration()
                .build()
                .also {
                    INSTANCE = it
                }
        }
    }
}