package com.example.ceilingtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ceilingtest.R

class RecyclerViewAdapter(private val data: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTextView.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mTextView: TextView = itemView.findViewById<TextView>(R.id.tv_index)
}