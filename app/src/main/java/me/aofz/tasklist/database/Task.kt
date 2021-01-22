package me.aofz.tasklist.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Long=0,

    @ColumnInfo(name = "task_title")
    var title: String?,

    @ColumnInfo(name = "task_description")
    var description: String?
):Parcelable
