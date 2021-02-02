package me.aofz.tasklist.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.databinding.ListItemBinding
import me.aofz.tasklist.model.Task

class ListViewHolder private constructor(private val viewBinding: ListItemBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(task: Task, onClick: (view: View, task: Task) -> Unit) {
        viewBinding.task = task
        viewBinding.root.setOnClickListener {
            it?.let {
                onClick(it, task)
            }
        }
        viewBinding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewBinding = ListItemBinding.inflate(layoutInflater, parent, false)
            return ListViewHolder(viewBinding)
        }
    }
}