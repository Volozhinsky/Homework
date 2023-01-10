package com.volozhinsky.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

const val PIC_COUNTER = "KEY_COUNTER"

class Lesson18Activity : AppCompatActivity() {

    private var counter = 0
    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson18)
        restore(savedInstanceState)
        setViews()
    }

    private fun setViews() {
        imageView = findViewById(R.id.imageView)
        updateUI()
        val nextPicButton = findViewById<Button>(R.id.nextPicButton)
        nextPicButton.setOnClickListener { incrementCounter() }
    }

    private fun restore(savedInstanceState: Bundle?) {
        counter = savedInstanceState?.getInt(PIC_COUNTER) ?: 0
    }

    private fun updateUI() {
        val picArray = resources.getStringArray(R.array.picArray)
        imageView?.let { Glide.with(this).load(picArray[counter]).into(it) }
    }

    private fun incrementCounter() {
        if (counter < 10) {
            counter += 1
        } else {
            counter = 0
        }
        updateUI()
    }
}