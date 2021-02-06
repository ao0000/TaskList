package me.aofz.tasklist.di

import me.aofz.tasklist.repository.TaskRepository
import org.koin.dsl.module


val RepositoryModule = module {
    single {
        TaskRepository(get())
    }
}