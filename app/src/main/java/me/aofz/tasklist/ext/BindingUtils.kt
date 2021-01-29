package me.aofz.tasklist.ext

import android.widget.TextView
import androidx.databinding.BindingAdapter
import me.aofz.tasklist.model.Task

@BindingAdapter("setItemTitle")
fun TextView.setItemTitle(item: Task) {
    text = item.title
}

@BindingAdapter("setItemDescription")
fun TextView.setItemDescription(item: Task) {
    text = item.description
}