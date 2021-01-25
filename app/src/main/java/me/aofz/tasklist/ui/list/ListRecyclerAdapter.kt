package me.aofz.tasklist.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.R
import me.aofz.tasklist.data.db.TaskEntity

class ListRecyclerAdapter(
    private val onItemClick: (view: View, position: Int) -> Unit
) :
    RecyclerView.Adapter<ListRecyclerAdapter.ListRecyclerViewHolder>() {
    private var data = emptyList<TaskEntity>()

    fun setData(data: List<TaskEntity>){
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
    class ListRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val titleTextView: TextView = view.findViewById(R.id.list_title_text)
        val descriptionTextView: TextView = view.findViewById(R.id.list_description_text)

    }
}