package com.volozhinsky.homework.Lesson19

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.volozhinsky.homework.R

class FilmListViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
    fun bind(item:FilmInfo){
        val name = itemView.findViewById<TextView>(R.id.tvFilmName)
        val poster = itemView.findViewById<ImageView>(R.id.ivPoster)
        val rated = itemView.findViewById<TextView>(R.id.tvRated)
        val hasOscar = itemView.findViewById<ImageView>(R.id.ivOscar)
        name.text = item.name
        loadPoster(item.linkToPoster,poster)
        rated.text = item.Rated.toString()
        hasOscar.isVisible = item.hasOscar

    }
    private fun loadPoster(url:String,imageView: ImageView){
        Glide.with(imageView.context).load(url).into(imageView)
    }

}