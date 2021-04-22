package me.aofz.tasklist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    val id: Long = 0,
    val title: Title,
    val description: Description
) : Parcelable {
    fun toEntity(): TaskEntity = TaskEntity(id, title.toString(), description.toString())
}