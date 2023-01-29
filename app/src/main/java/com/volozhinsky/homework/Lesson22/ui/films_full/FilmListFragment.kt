package com.volozhinsky.homework.Lesson22.ui.films_full

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.Lesson22.data.models.FilmInfoResponse
import com.volozhinsky.homework.Lesson22.ui.films_full.presenter.FilmInfoPresenter
import com.volozhinsky.homework.Lesson22.ui.films_full.presenter.FilmInfoPresenterImpl
import com.volozhinsky.homework.Lesson22.ui.FilmListAdapter
import com.volozhinsky.homework.Lesson22.ui.film_describtion.FilmDescribtionFragment
import com.volozhinsky.homework.Lesson22.ui.models.FilmInfoUI
import com.volozhinsky.homework.R

class FilmListFragment : Fragment(), FilmInfoView {

    private var presenter: FilmInfoPresenter? = null
    private var resyvlerAdapter: FilmListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_film_list, container, false)
        view.findViewById<RecyclerView>(R.id.rvFilmListMVP).apply {
            resyvlerAdapter = FilmListAdapter(onClicFunc)
            adapter = resyvlerAdapter
            layoutManager =
               LinearLayoutManager(this@FilmListFragment.context, LinearLayoutManager.VERTICAL, false)
        }
        presenter = FilmInfoPresenterImpl(this)
        val startFragmentLowRatedFilmsButton = view.findViewById<Button>(R.id.bStartFragmentLowRatedFilms)
        startFragmentLowRatedFilmsButton.setOnClickListener{
            startFragmentLowRatedFilms()
        }
        return view
    }

    private fun startFragmentLowRatedFilms() {
        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.getFilmInfo()
    }

    override fun setViewAdapterData(listFilmInfoResponse: List<FilmInfoUI>) {
        resyvlerAdapter?.setFilmInfoData(listFilmInfoResponse)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onClear()
    }

    private val onClicFunc: (FilmInfoUI) -> Unit = { filminfo ->
        val filmDescribtionFragment =
            FilmDescribtionFragment.newInstance(filminfo.name, filminfo.description)
        requireActivity().supportFragmentManager.beginTransaction()
            .addToBackStack("ListFragment")
            .replace(R.id.fragment_L22, filmDescribtionFragment).commit()
    }

    companion object {

        fun newInstance() = FilmListFragment()
    }

}