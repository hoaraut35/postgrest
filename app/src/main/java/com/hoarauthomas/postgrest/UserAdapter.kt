package com.hoarauthomas.postgrest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hoarauthomas.postgrest.models.CarsResponseItem

class UserAdapter (private val myUsers: List<CarsResponseItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.user_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_user, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val contact: CarsResponseItem = myUsers.get(position)
        // Set item views based on your views and data model
        val textView = holder.nameTextView
        textView.text = contact.maker


    }

    override fun getItemCount(): Int {
        return myUsers.size
    }

}