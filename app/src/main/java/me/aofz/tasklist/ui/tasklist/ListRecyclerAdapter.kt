package me.aofz.tasklist.ui.tasklist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import me.aofz.tasklist.model.Task

class ListRecyclerAdapter(private val onClick: (view: View, task: Task) -> Unit) :
    ListAdapter<Task, ListViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task, onClick)
    }
}