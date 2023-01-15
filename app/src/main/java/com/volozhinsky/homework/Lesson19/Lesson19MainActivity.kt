package com.volozhinsky.homework.Lesson19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.volozhinsky.homework.R

class Lesson19MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson19_main)
        val filmList = Server.getFilmListData()
        val adapter = FilmListAdapter(filmList)
        findViewById<RecyclerView>(R.id.rvFilmList).apply {
            this.adapter = adapter
            layoutManager =
            LinearLayoutManager(this@Lesson19MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }
}