package com.volozhinsky.homework.Lesson21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.volozhinsky.homework.R


class Lesson21ResultFragment : Fragment() {

    companion object {
        const val ARG_COLOR_INDEX = "ARG_COLOR_INDEX"

        fun newInstance(colorIndex: Int) =
            Lesson21ResultFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLOR_INDEX, colorIndex)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lesson21_result, container, false)
        arguments?.let {
            val background =
                resources.getIntArray(R.array.colorsResultBack)[it.getInt(ARG_COLOR_INDEX)]
            view.setBackgroundColor(background)
        }
        return view
    }
}