package com.volozhinsky.homework.Lesson20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.R

class WebsiteListAdapter(private val webSiteList: List<WebsiteСhapterInfo>,private val onClicFunc: (WebsiteInfo) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val WEBSITE_INFO_TYPE = 1
        const val CHAPTER_INFO_TYPE = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            WEBSITE_INFO_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.rv_item_website_info, parent, false)
                WebsiteListViewHolder(view,onClicFunc)
            }
            CHAPTER_INFO_TYPE -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.rv_item_chapter_info, parent, false)
                ChapterListViewHolder(view)
            }
            else -> throw Exception()
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is WebsiteListViewHolder -> holder.bind(webSiteList[position] as WebsiteInfo)
            is ChapterListViewHolder -> holder.bind(webSiteList[position] as ChapterInfo)
        }
    }

    override fun getItemCount(): Int = webSiteList.size

    override fun getItemViewType(position: Int): Int {
        return when (webSiteList[position]) {
            is WebsiteInfo -> WEBSITE_INFO_TYPE
            is ChapterInfo -> CHAPTER_INFO_TYPE
        }
    }
}