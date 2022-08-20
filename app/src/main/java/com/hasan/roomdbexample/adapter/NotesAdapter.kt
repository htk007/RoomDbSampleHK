package com.hasan.roomdbexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hasan.roomdbexample.R
import com.hasan.roomdbexample.data.Note
import android.widget.AdapterView.OnItemClickListener




class NotesAdapter(private val mList: List<Note>,
                   private val listener: (Note) -> Unit) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the note_item view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.noteText
        holder.itemView.setOnClickListener { listener(itemsViewModel) }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}