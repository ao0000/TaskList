package me.aofz.tasklist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    val id: Long = 0,
    val title: String,
    val description: String
) : Parcelable {
    fun toEntity(): TaskEntity =
        TaskEntity(id, title, description)
}