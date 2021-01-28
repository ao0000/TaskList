package me.aofz.tasklist.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.R
import me.aofz.tasklist.model.Task

class ListRecyclerAdapter(private val onClick: (view: View, task: Task) -> Unit) :
    RecyclerView.Adapter<ListRecyclerAdapter.ListViewHolder>() {

    var data = emptyList<Task>()

    fun submitList(data: List<Task>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.description.text = data[position].description
        holder.itemView.setOnClickListener{
            onClick(holder.itemView, data[position])
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.list_title_text)
        val description: TextView = itemView.findViewById(R.id.list_description_text)
    }
}