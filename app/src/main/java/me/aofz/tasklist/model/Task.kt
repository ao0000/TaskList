package me.aofz.tasklist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Task(
    val id: Long = 0,
    val title: Title,
    val description: String
) : Parcelable {
    fun toEntity(): TaskEntity = TaskEntity(id, title.toString(), description)
}

@Parcelize
data class Title(val value: String) : Parcelable {
    init {
        require(value.isNotEmpty())
    }

    override fun toString(): String = value
}