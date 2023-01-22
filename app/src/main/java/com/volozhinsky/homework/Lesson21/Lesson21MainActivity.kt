package com.volozhinsky.homework.Lesson21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.volozhinsky.homework.R

class Lesson21MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson21_main)
        val spinner = findViewById<Spinner>(R.id.spinnerL21)
        if (spinner != null) {
            val namesColor = resources.getStringArray(R.array.colorNames)
            val spinerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, namesColor)
            spinner.adapter = spinerAdapter
        }
        findViewById<Button>(R.id.buttonL21).setOnClickListener {
            val resultFragment = Lesson21ResultFragment.newInstance(spinner.selectedItemPosition)
            supportFragmentManager.beginTransaction()
                .addToBackStack("BACKSTACK")
                .replace(R.id.flColorFrame, resultFragment)
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}