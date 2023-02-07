package com.volozhinsky.homework.Lesson22.ui.film_describtion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.volozhinsky.homework.R
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Thread.sleep

@AndroidEntryPoint
class FilmDescribtionFragment : Fragment() {

    private val filmDescribtionViewModel by viewModels<FilmDescribtionViewModel>()
    val args: FilmDescribtionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameTextView = view.findViewById<TextView>(R.id.tvName)
        val describtionTextView = view.findViewById<TextView>(R.id.tvDescribtion)
        filmDescribtionViewModel.liveData.observe(viewLifecycleOwner) {
            nameTextView?.text = it.name
            describtionTextView?.text = it.description
        }
        filmDescribtionViewModel.getFilmInfo(args.nameOfFilminfo)
//        val uiRannable =   Runnable{
//                sleep(10000)
//                nameTextView.text = "ФоновыйПоток"
//                nameTextView.post{
//                    nameTextView.text = "ФоновыйПоток"
//            }
//        }
//        Thread(uiRannable).start()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_film_describtion, container, false)
    }
}