package me.aofz.tasklist.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.R
import me.aofz.tasklist.database.Task

class ListRecyclerAdapter(
//    private val data: List<Task>,
    private val onItemClick: (view: View, position: Int) -> Unit
) :
    RecyclerView.Adapter<ListRecyclerViewHolder>() {
    private var data = emptyList<Task>()

    fun setData(data: List<Task>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ListRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListRecyclerViewHolder, position: Int) {

        holder.titleTextView.text = data[position].title
        holder.descriptionTextView.text = data[position].description
        holder.itemView.setOnClickListener{
            onItemClick(it, position)
        }

    }

}