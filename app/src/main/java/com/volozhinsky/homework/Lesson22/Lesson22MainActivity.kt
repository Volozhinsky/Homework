package com.volozhinsky.homework.Lesson22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.volozhinsky.homework.Lesson22.ui.FilmListFragment
import com.volozhinsky.homework.R

class Lesson22MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson22_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_L22, FilmListFragment.newInstance()).commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}