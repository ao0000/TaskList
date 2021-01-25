package me.aofz.tasklist.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.R
import me.aofz.tasklist.model.Task

class ListRecyclerAdapter(
    private val onItemClick: (view: View, task: Task) -> Unit
) :
    ListAdapter<Task, ListRecyclerAdapter.ListRecyclerViewHolder>(TaskDiffCallback) {
    private var data = emptyList<Task>()

    fun setData(data: List<Task>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListRecyclerViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ListRecyclerViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task)
    }

    class ListRecyclerViewHolder(
        itemView: View,
        private val onItemClick: (view: View, task: Task) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val titleTextView: TextView = itemView.findViewById(R.id.list_title_text)
        private val descriptionTextView: TextView =
            itemView.findViewById(R.id.list_description_text)
        private var currentTask: Task? = null

        init {
            itemView.setOnClickListener { view ->
                currentTask?.let {
                    onItemClick(view, currentTask!!)
                }
            }
        }

        fun bind(task: Task) {
            currentTask = task
            titleTextView.text = task.description
            descriptionTextView.text = task.description
        }
    }

}
object TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }
}