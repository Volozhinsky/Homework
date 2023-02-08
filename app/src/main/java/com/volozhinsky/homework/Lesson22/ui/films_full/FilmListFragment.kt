package com.volozhinsky.homework.Lesson22.ui.films_full

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.Lesson22.ui.FilmListAdapter
import com.volozhinsky.homework.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmListFragment : Fragment() {

    private val filmListInfoViewModel by viewModels<FilmListViewModel>()
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
                LinearLayoutManager(
                    this@FilmListFragment.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
        view.findViewById<Button>(R.id.bStartFragmentLowRatedFilms).setOnClickListener {
            startFragmentLowRatedFilms()
        }
        return view
    }

    private fun startFragmentLowRatedFilms() {
        val action =
            FilmListFragmentDirections.actionFilmListFragmentToLowRatedFilmsFragment()
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filmListInfoViewModel.liveData.observe(viewLifecycleOwner) {
            resyvlerAdapter?.setFilmInfoData(it)
        }
        filmListInfoViewModel.errorliveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), getString(it), Toast.LENGTH_SHORT).show()
        }
        filmListInfoViewModel.getFilmInfo()
        val progressBar = view.findViewById<ProgressBar>(R.id.filmlistProgressBar)
        filmListInfoViewModel.progressBarliveData.observe(viewLifecycleOwner) {
            progressBar.isVisible = it
        }
        filmListInfoViewModel.showFavorites()
        view.findViewById<Button>(R.id.btShowFavorite).setOnClickListener {
            filmListInfoViewModel.showFavorites()
        }
        filmListInfoViewModel.describtionFavoriteFilm.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    private val onClicFunc: (String) -> Unit = { nameOfFilmInfo ->
        val action = FilmListFragmentDirections.actionFilmListFragmentToFilmDescribtionFragment(
            nameOfFilmInfo
        )
        findNavController().navigate(action)
    }
}