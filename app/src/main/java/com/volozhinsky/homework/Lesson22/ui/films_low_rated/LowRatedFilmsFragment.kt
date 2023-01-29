package com.volozhinsky.homework.Lesson22.ui.films_low_rated

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.Lesson22.ui.FilmListAdapter
import com.volozhinsky.homework.Lesson22.ui.film_describtion.FilmDescribtionFragment
import com.volozhinsky.homework.Lesson22.ui.films_low_rated.presenter.LowRatedFilmInfoPresenter
import com.volozhinsky.homework.Lesson22.ui.films_low_rated.presenter.LowRatedFilmInfoPresenterImpl
import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI
import com.volozhinsky.homework.R

class LowRatedFilmsFragment : Fragment(),LowRatedFilmInfoView {

    private var presenter: LowRatedFilmInfoPresenter? = null
    private var resyclerAdapter: FilmListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_low_rated_films, container, false)
        view.findViewById<RecyclerView>(R.id.rvLowRatedFilmList).apply {
            resyclerAdapter = FilmListAdapter(onClicFunc)
            adapter = resyclerAdapter
            layoutManager =
                LinearLayoutManager(this@LowRatedFilmsFragment.context, LinearLayoutManager.VERTICAL, false)
        }
        presenter = LowRatedFilmInfoPresenterImpl(this)
        return view
    }

    private val onClicFunc: (FilmInfoUI) -> Unit = { filminfo ->
        val filmDescribtionFragment =
            FilmDescribtionFragment.newInstance(filminfo.name, filminfo.description)
        requireActivity().supportFragmentManager.beginTransaction()
            .addToBackStack("ListFragment")
            .replace(R.id.fragment_L22, filmDescribtionFragment).commit()
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            LowRatedFilmsFragment()
    }

    override fun setViewAdapterData(listFilmInfoUI: List<FilmInfoUI>) {
        resyclerAdapter?.setFilmInfoData(listFilmInfoUI)
    }
}