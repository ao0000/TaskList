package me.aofz.tasklist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Title(val value: String) : Parcelable {
    init {
        require(value.isNotEmpty())
    }

    override fun toString(): String = value
}