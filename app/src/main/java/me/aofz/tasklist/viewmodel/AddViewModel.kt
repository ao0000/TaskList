package me.aofz.tasklist.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.aofz.tasklist.model.Task

class AddViewModel: ViewModel() {

    private suspend fun insertTask(task : Task){
        withContext(Dispatchers.IO){

        }
    }
}