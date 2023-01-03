package com.volozhinsky.homework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Lesson17HWResultActivity : AppCompatActivity() {
    companion object {
        const val KEY_NEW_INTENT_COUNTER = "KEY_NEW_INTENT_COUNTER"
        fun newIntent(count: Int, context: Context): Intent {
            val intent = Intent(context, Lesson17HWResultActivity::class.java)
            intent.putExtra(KEY_NEW_INTENT_COUNTER, count)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson17_hwresult)
        val counterTextView = findViewById<TextView>(R.id.resultTextView)
        counterTextView.text =
            getString(R.string.result_textview_text, intent.getIntExtra(KEY_NEW_INTENT_COUNTER, 0))
    }


}