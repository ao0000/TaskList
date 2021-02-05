package me.aofz.tasklist.di

import me.aofz.tasklist.ui.addtask.AddViewModel
import me.aofz.tasklist.ui.list.ListViewModel
import me.aofz.tasklist.ui.taskdetail.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelComponent = module {
    viewModel { AddViewModel(get()) }
    viewModel { ListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}