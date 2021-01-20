package me.aofz.tasklist.list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.aofz.tasklist.R

class ListRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val titleTextView: TextView = view.findViewById(R.id.list_title_text)
    val descriptionTextView: TextView = view.findViewById(R.id.list_description_text)

}