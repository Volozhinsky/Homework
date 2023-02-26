package com.volozhinsky.homework.lesson22.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.lesson22.ui.models.FilmInfoUI
import com.volozhinsky.homework.databinding.RvItemFilmInfoBinding

class FilmListAdapter(private val onClicFunc: (String) -> Unit) :
    RecyclerView.Adapter<FilmListViewHolder>() {

    private var mListFilmInfoResponse: MutableList<FilmInfoUI> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = RvItemFilmInfoBinding.inflate(layoutInflater,parent, false)
        return FilmListViewHolder(itemBinding,onClicFunc)
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