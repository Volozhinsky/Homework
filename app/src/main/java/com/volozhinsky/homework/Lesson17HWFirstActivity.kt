package com.volozhinsky.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

const val KEY_COUNTER = "KEY_COUNTER"

class Lesson17HWFirstActivity : AppCompatActivity() {

    private var counter = 0
    private lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson17_hwfirst)
        restore(savedInstanceState)
        setViews()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, counter)
    }

    private fun setViews() {
        counterTextView = findViewById(R.id.counterTextView)
        updateUI()
        val incrementButtonTextView = findViewById<TextView>(R.id.incrementButtonTextView)
        incrementButtonTextView.setOnClickListener { incrementCounter() }
        val startSecondActivityButtonTextView =
            findViewById<TextView>(R.id.startSecondActivityButtonTextView)
        startSecondActivityButtonTextView.setOnClickListener { startResultActivity() }
    }

    private fun restore(savedInstanceState: Bundle?) {
        counter = savedInstanceState?.getInt(KEY_COUNTER) ?: 0
    }

    private fun incrementCounter() {
        counter += 1
        updateUI()
    }

    private fun updateUI() {
        counterTextView.text = getString(R.string.counterTextView, counter)
    }

    private fun startResultActivity() {
        startActivity(Lesson17HWResultActivity.newIntent(counter, this))
    }
}