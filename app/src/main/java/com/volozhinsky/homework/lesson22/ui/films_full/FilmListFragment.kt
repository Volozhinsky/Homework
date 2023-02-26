package com.volozhinsky.homework.lesson22.ui.films_full

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.volozhinsky.homework.lesson22.ui.FilmListAdapter
import com.volozhinsky.homework.R
import com.volozhinsky.homework.databinding.FragmentFilmListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmListFragment : Fragment() {

    private var _binding: FragmentFilmListBinding? = null
    private val binding get() = _binding!!
    private val filmListInfoViewModel by viewModels<FilmListViewModel>()
    private var resyvlerAdapter: FilmListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_film_list,container,false)
        _binding = DataBindingUtil.bind(viewRoot)
        return viewRoot
    }

    private fun startFragmentLowRatedFilms() {
        val action =
            FilmListFragmentDirections.actionFilmListFragmentToLowRatedFilmsFragment()
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = filmListInfoViewModel
        binding.rvFilmListMVP.apply {
            resyvlerAdapter = FilmListAdapter(onClicFunc)
            adapter = resyvlerAdapter
            layoutManager =
                LinearLayoutManager(
                    this@FilmListFragment.context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
        binding.bStartFragmentLowRatedFilms.setOnClickListener {
            startFragmentLowRatedFilms()
        }
        initLiveData()
    }

    private fun initLiveData(){
        filmListInfoViewModel.liveData.observe(viewLifecycleOwner) {
            resyvlerAdapter?.setFilmInfoData(it)
        }
        filmListInfoViewModel.errorliveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), getString(it), Toast.LENGTH_SHORT).show()
        }
        filmListInfoViewModel.getFilmInfo()

        filmListInfoViewModel.showFavorites()
        binding.btShowFavorite.setOnClickListener {
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