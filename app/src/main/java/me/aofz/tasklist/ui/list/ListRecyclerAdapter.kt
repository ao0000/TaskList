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
        return ListViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(data[position], onClick)
    }

    class ListViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.list_title_text)
        val description: TextView = itemView.findViewById(R.id.list_description_text)

        fun bind(data: Task, onClick: (view: View, task: Task) -> Unit){
            title.text = data.title
            description.text = data.description
            itemView.setOnClickListener{
                it?.let{
                    onClick(it, data)
                }
            }
        }

        companion object{
            fun from(parent: ViewGroup): ListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
                return ListViewHolder(itemView)
            }
        }
    }
}