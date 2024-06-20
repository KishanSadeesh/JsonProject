package com.example.jsonproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.jsonproject.network.MarsPhoto

class MarsAdapter(var listMarsPhotos: List<MarsPhoto>) : RecyclerView.Adapter<MarsAdapter.MarsViewHolder>(){
    class MarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textview: TextView = itemView.findViewById(R.id.tvUrl)
        var MarsImageView: ImageView = itemView.findViewById(R.id.ivPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        var rowPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return MarsViewHolder(rowPlank)

    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        var url = listMarsPhotos[position].imgSrc
        holder.textview.setText(url)
        holder.MarsImageView.load(url)
    }

    override fun getItemCount(): Int {
        return listMarsPhotos.size
    }
}