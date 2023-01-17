package com.volozhinsky.homework.Lesson20

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.R

class WebsiteListViewHolder(itemView: View, private val onClicFunc: (WebsiteInfo) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(item: WebsiteInfo) {
        itemView.findViewById<TextView>(R.id.tvWebsiteInfo).text = item.name
        itemView.setOnClickListener {
            onClicFunc.invoke(item)
        }
    }
}