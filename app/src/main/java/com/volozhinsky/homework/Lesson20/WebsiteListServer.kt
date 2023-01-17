package com.volozhinsky.homework.Lesson20

import android.net.Uri

object WebsiteListServer {

    fun getWebsiteListData():List<WebsiteСhapterInfo> =  listOf(
        ChapterInfo("Новости"),
        WebsiteInfo("Onlíner", Uri.parse("https://www.onliner.by")),
        WebsiteInfo("Яндекс дзен", Uri.parse("https://dzen.ru")),
        ChapterInfo("Социальные сети"),
        WebsiteInfo("В контакте", Uri.parse("https://vk.ru")),
        WebsiteInfo("Инстаграмм", Uri.parse("https://www.instagram.com")),
        ChapterInfo("Фильмы"),
        WebsiteInfo("Кинопоиск", Uri.parse("https://www.kinopoisk.ru")),
        WebsiteInfo("Ivi", Uri.parse("https://www.ivi.ru")),
        ChapterInfo("Другие"),
        WebsiteInfo("Налоговая", Uri.parse("https://nalog.gov.by")),
        WebsiteInfo("21 век", Uri.parse("https://www.21vek.by")),
        )
}