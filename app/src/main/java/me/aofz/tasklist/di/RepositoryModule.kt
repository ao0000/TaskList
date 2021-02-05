package me.aofz.tasklist.di

import me.aofz.tasklist.data.repository.TaskRepository
import org.koin.dsl.module


val RepositoryModule = module {
    single {
        TaskRepository(get())
    }
}