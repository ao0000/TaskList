package me.aofz.tasklist.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.R
import me.aofz.tasklist.databinding.ListItemBinding
import me.aofz.tasklist.model.Task

class ListRecyclerAdapter(private val onClick: (view: View, task: Task) -> Unit) :
    ListAdapter<Task, ListRecyclerAdapter.ListViewHolder>(SleepNightDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClick)
    }

    class ListViewHolder private constructor(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task, onClick: (view: View, task: Task) -> Unit){
            binding.listTitleText.text = task.title
            binding.listDescriptionText.text = task.description
            binding.root.setOnClickListener {
                it?.let{
                    onClick(it, task)
                }
            }
        }

        companion object{
            fun from(parent: ViewGroup): ListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ListViewHolder(binding)
            }
        }
    }
}

class SleepNightDiffCallback: DiffUtil.ItemCallback<Task>(){
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id   == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}