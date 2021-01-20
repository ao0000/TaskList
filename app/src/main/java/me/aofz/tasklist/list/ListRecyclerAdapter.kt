package me.aofz.tasklist.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.R
import me.aofz.tasklist.database.Task

class ListRecyclerAdapter(private val data: List<Task>) :
    RecyclerView.Adapter<ListRecyclerViewHolder>() {

    override fun getItemCount(): Int = data.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.list_item,
                parent,
                false
            )

        return ListRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListRecyclerViewHolder, position: Int) {

        holder.titleTextView.text = data[position].title
        holder.descriptionTextView.text = data[position].description

    }

}