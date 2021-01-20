package me.aofz.tasklist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(

    @PrimaryKey(autoGenerate = true)
    val id: Long?,

    @ColumnInfo(name = "task_title")
    val title: String?,

    @ColumnInfo(name = "task_description")
    val description: String?

)
