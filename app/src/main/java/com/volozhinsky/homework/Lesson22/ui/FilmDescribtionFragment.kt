package com.volozhinsky.homework.Lesson22.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.volozhinsky.homework.R

class FilmDescribtionFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            view.findViewById<TextView>(R.id.tvName).text = it.getString(ARG_NAME)
            view.findViewById<TextView>(R.id.tvDescribtion).text = it.getString(ARG_DECSRIBTION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_film_describtion, container, false)
    }

    companion object {
        const val ARG_DECSRIBTION = "ARG_DECSRIBTION"
        const val ARG_NAME = "ARG_NAME"

        fun newInstance(name: String, describtion: String) =
            FilmDescribtionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_DECSRIBTION,describtion)
                    putString(ARG_NAME, name)
                }
            }
    }
}