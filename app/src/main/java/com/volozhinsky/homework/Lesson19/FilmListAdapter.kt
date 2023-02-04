package com.volozhinsky.homework.Lesson19

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.Lesson20.WebsiteInfo
import com.volozhinsky.homework.R

class FilmListAdapter(val listFilmInfo: List<FilmInfo>,private val onClicFunc: (FilmInfo) -> Unit) :
    RecyclerView.Adapter<FilmListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_film_info, parent, false)
        return FilmListViewHolder(view,onClicFunc)
    }

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        holder.bind(listFilmInfo[position])
    }

    override fun getItemCount(): Int = listFilmInfo.size
}