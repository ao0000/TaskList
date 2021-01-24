package me.aofz.tasklist.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.aofz.tasklist.model.Task

@Entity(tableName = "task_table")
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    var id: Long = 0,

    @ColumnInfo(name = "task_title")
    var title: String = "",

    @ColumnInfo(name = "task_description")
    var description: String = ""

) {
    fun toTask() = Task(id, title, description)
}