package me.aofz.tasklist.di

import androidx.room.Room
import me.aofz.tasklist.data.db.TaskDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DatabaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext().applicationContext,
            TaskDatabase::class.java,
            "task_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    single {
        get<TaskDatabase>().taskDatabaseDAO()
    }
}