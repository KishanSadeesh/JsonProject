package com.example.jsonproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsonproject.network.MarsPhoto

class MarsAdapter(var listMarsPhotos: List<MarsPhoto>) : RecyclerView.Adapter<MarsAdapter.MarsViewHolder>(){
    class MarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textview: TextView = itemView.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        var rowPlank = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return MarsViewHolder(rowPlank)

    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        holder.textview.setText(listMarsPhotos[position].imgSrc)
    }

    override fun getItemCount(): Int {
        return listMarsPhotos.size
    }
}