package com.volozhinsky.homework.Lesson22.ui.films_low_rated

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.volozhinsky.homework.Lesson22.ui.FilmListAdapter
import com.volozhinsky.homework.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LowRatedFilmsFragment : Fragment(){

    private val lowRatedFilmsViewModel by viewModels<LowRatedFilmsViewModel>()
    private var recyclerAdapter: FilmListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_low_rated_films, container, false)
        view.findViewById<RecyclerView>(R.id.rvLowRatedFilmList).apply {
            recyclerAdapter = FilmListAdapter(onClicFunc)
            adapter = recyclerAdapter
            layoutManager =
                LinearLayoutManager(this@LowRatedFilmsFragment.context, LinearLayoutManager.VERTICAL, false)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lowRatedFilmsViewModel.liveData.observe(viewLifecycleOwner) {
            recyclerAdapter?.setFilmInfoData(it)
        }
        lowRatedFilmsViewModel.getFilmInfo()
    }

    private val onClicFunc: (String) -> Unit = { nameOfFilmInfo ->
        val action = LowRatedFilmsFragmentDirections.actionLowRatedFilmsFragmentToFilmDescribtionFragment(nameOfFilmInfo)
        findNavController().navigate(action)
    }
}