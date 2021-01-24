package me.aofz.tasklist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDatabaseDAO: TaskDatabaseDAO

    companion object {
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context) = INSTANCE
            ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                TaskDatabase::class.java,
                "task_database"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
                .also {
                    INSTANCE = it
                }
        }
    }
}