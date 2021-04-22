package me.aofz.tasklist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    var id: Long = 0,

    @ColumnInfo(name = "task_title")
    var title: String,

    @ColumnInfo(name = "task_description")
    var description: String = ""

) {
    fun toTask(): Task = Task(
        id,
        Title(title),
        Description(description)
    )
}