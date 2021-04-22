package me.aofz.tasklist.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Description(val value: String) : Parcelable {
    override fun toString(): String = value
}