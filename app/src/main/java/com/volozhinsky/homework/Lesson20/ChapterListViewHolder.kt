package com.volozhinsky.homework.Lesson20

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.R

class ChapterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: ChapterInfo) {
        itemView.findViewById<TextView>(R.id.tvChapterInfo).text = item.name
    }
}