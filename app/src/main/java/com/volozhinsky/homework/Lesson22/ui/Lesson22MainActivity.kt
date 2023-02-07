package com.volozhinsky.homework.Lesson22.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import com.volozhinsky.homework.Lesson22.ui.films_full.FilmListFragment
import com.volozhinsky.homework.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Lesson22MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson22_main)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!findNavController(R.id.hostNavId).navigateUp()) {
                    finish()
                }
            }
        })
    }
}