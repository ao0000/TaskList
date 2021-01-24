package me.aofz.tasklist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import me.aofz.tasklist.data.db.TaskEntity

@Parcelize
data class Task(
    val id: Long,
    val title: String,
    val description: String
) : Parcelable {
    fun toEntity() = TaskEntity(id, title, description)
}