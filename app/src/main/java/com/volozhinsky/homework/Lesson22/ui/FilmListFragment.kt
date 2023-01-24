package com.volozhinsky.homework.Lesson22.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.Lesson22.model.models.FilmInfo
import com.volozhinsky.homework.Lesson22.presenter.FilmInfoPresenter
import com.volozhinsky.homework.Lesson22.presenter.FilmInfoPresenterImpl
import com.volozhinsky.homework.R

class FilmListFragment : Fragment(), FilmInfoView {

    private var presenter: FilmInfoPresenter = FilmInfoPresenterImpl(this)
    private val onClicFunc: (FilmInfo) -> Unit = { filminfo ->
        val filmDescribtionFragment =
            FilmDescribtionFragment.newInstance(filminfo.name, filminfo.description)

        requireActivity().supportFragmentManager.beginTransaction()
            .addToBackStack("ListFragment")
            .replace(R.id.fragment_L22, filmDescribtionFragment).commit()
    }

    private val resyvlerAdapter = FilmListAdapter(onClicFunc)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_film_list, container, false)
        view.findViewById<RecyclerView>(R.id.rvFilmListMVP).apply {
        adapter = resyvlerAdapter
        layoutManager =
            LinearLayoutManager(this@FilmListFragment.context, LinearLayoutManager.VERTICAL, false)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getFilmInfo()
    }

    override fun setViewAdapterData(listFilmInfo: List<FilmInfo>) {
        resyvlerAdapter.setFilmInfoData(listFilmInfo)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onClear()
    }

    companion object {

        fun newInstance() = FilmListFragment()
    }
}