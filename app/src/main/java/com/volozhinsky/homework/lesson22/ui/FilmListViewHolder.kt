package com.volozhinsky.homework.lesson22.ui

import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.volozhinsky.homework.lesson22.ui.models.FilmInfoUI
import com.volozhinsky.homework.databinding.RvItemFilmInfoBinding

class FilmListViewHolder(
    private val itemBinding: RvItemFilmInfoBinding,
    private val onClicFunc: (String) -> Unit
) : RecyclerView.ViewHolder(itemBinding.root) {
    fun bind(item: FilmInfoUI) {
        val name = itemBinding.tvFilmName
        val poster = itemBinding.ivPoster
        val rated = itemBinding.tvRated
        val hasOscar = itemBinding.ivOscar
        name.text = item.name
        loadPoster(item.linkToPoster, poster)
        rated.text = item.Rated.toString()
        hasOscar.isVisible = item.hasOscar
        itemView.setOnClickListener {
            onClicFunc.invoke(item.name)
        }
    }

    private fun loadPoster(url: String, imageView: ImageView) {
        Glide.with(imageView.context).load(url).into(imageView)
    }
}