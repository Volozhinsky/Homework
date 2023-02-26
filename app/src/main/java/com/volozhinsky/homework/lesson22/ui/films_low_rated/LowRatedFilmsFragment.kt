package com.volozhinsky.homework.lesson22.ui.films_low_rated

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.volozhinsky.homework.lesson22.ui.FilmListAdapter
import com.volozhinsky.homework.R
import com.volozhinsky.homework.databinding.FragmentLowRatedFilmsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LowRatedFilmsFragment : Fragment(){

    private var _binding: FragmentLowRatedFilmsBinding? = null
    private val binding get() = _binding!!
    private val lowRatedFilmsViewModel by viewModels<LowRatedFilmsViewModel>()
    private var recyclerAdapter: FilmListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_low_rated_films,container,false)
        _binding = DataBindingUtil.bind(viewRoot)
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvLowRatedFilmList.apply {
            recyclerAdapter = FilmListAdapter(onClicFunc)
            adapter = recyclerAdapter
            layoutManager =
                LinearLayoutManager(this@LowRatedFilmsFragment.context, LinearLayoutManager.VERTICAL, false)
        }
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