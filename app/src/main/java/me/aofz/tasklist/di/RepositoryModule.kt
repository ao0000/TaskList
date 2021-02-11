package me.aofz.tasklist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.aofz.tasklist.repository.TaskRepository
import me.aofz.tasklist.repository.db.TaskDatabaseDAO
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(databaseDAO: TaskDatabaseDAO): TaskRepository{
        return TaskRepository(databaseDAO)
    }

}