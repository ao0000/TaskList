package me.aofz.tasklist.ui.tasklist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.databinding.ListItemBinding
import me.aofz.tasklist.model.Task

class ListAdapter(private val onClicked: (task: Task) -> Unit) :
    PagingDataAdapter<Task, TaskViewHolder>(
        DiffCallBack()
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder =
        TaskViewHolder.create(
            parent
        )

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int): Unit =
        holder.bind(getItem(position), onClicked)
}

class TaskViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    var value: Task? = null

    fun bind(task: Task?, onClicked: (task: Task) -> Unit) {
        task ?: return
        value = task
        binding.task = task
        binding.root.setOnClickListener { onClicked(task) }
    }

    companion object {
        fun create(parent: ViewGroup): TaskViewHolder {
            val binding: ListItemBinding =
                ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TaskViewHolder(binding)
        }
    }
}

class DiffCallBack : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean =
        oldItem == newItem
}