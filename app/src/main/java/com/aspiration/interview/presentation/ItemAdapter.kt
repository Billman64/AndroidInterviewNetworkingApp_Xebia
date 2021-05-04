package com.aspiration.interview.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aspiration.interview.R
import com.aspiration.interview.data.model.LatinMediaItem

class ItemAdapter(private var mediaList:List<LatinMediaItem>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val idView = itemView.findViewById<TextView>(R.id.id_textview)
        val titleView = itemView.findViewById<TextView>(R.id.title_textview)
        val bodyView = itemView.findViewById<TextView>(R.id.body_textview)
        val userIdView = itemView.findViewById<TextView>(R.id.userid_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = mediaList[position]

        holder.idView.text = currentItem.id.toString()
        holder.titleView.text = currentItem.title
        holder.bodyView.text = currentItem.body
        holder.userIdView.text = currentItem.userId.toString()
    }

    override fun getItemCount(): Int {
        return mediaList.count()
    }
}