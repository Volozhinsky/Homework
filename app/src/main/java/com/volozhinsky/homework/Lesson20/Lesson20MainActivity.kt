package com.volozhinsky.homework.Lesson20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.Lesson19.FilmListAdapter
import com.volozhinsky.homework.Lesson19.Server
import com.volozhinsky.homework.R

class Lesson20MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson20_main)
        val websiteList = WebsiteListServer.getWebsiteListData()
        val websiteListAdapter = WebsiteListAdapter(websiteList, onItemClick)
        findViewById<RecyclerView>(R.id.rvWebsiteList).apply {
            adapter = websiteListAdapter
            layoutManager =
                LinearLayoutManager(this@Lesson20MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    private val onItemClick: (item: WebsiteInfo) -> Unit = { vebsiteInfo ->
        val newIntent = Intent(Intent.ACTION_VIEW, vebsiteInfo.uri)
        if (newIntent.resolveActivity(packageManager) != null) {
            startActivity(newIntent)
        } else {
            Log.d("Intent", "Нет браузера")
        }
    }
}