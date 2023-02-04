package com.volozhinsky.homework.Lesson22.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.Lesson22.data.models.FilmInfoResponse
import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI
import com.volozhinsky.homework.R

class FilmListAdapter(private val onClicFunc: (String) -> Unit) :
    RecyclerView.Adapter<FilmListViewHolder>() {

    private var mListFilmInfoResponse: MutableList<FilmInfoUI> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_film_info, parent, false)
        return FilmListViewHolder(view,onClicFunc)
    }

    override fun onBindViewHolder(holder: FilmListViewHolder, position: Int) {
        holder.bind(mListFilmInfoResponse[position])
    }

    override fun getItemCount(): Int = mListFilmInfoResponse.size

    fun setFilmInfoData(list: List<FilmInfoUI>){
        this.mListFilmInfoResponse.clear()
        this.mListFilmInfoResponse.addAll(list)
        notifyDataSetChanged()
    }
}