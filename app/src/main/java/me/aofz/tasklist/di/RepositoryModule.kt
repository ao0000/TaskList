package me.aofz.tasklist.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import me.aofz.tasklist.repository.TaskRepository
import me.aofz.tasklist.repository.TaskRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideRepository(taskRepositoryImpl: TaskRepositoryImpl): TaskRepository

}