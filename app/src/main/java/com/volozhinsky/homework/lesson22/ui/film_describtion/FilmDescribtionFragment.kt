package com.volozhinsky.homework.lesson22.ui.film_describtion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.volozhinsky.homework.R
import com.volozhinsky.homework.databinding.FragmentFilmDescribtionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmDescribtionFragment : Fragment() {

    private var _binding: FragmentFilmDescribtionBinding? = null
    private val binding get() = _binding!!
    private val filmDescribtionViewModel by viewModels<FilmDescribtionViewModel>()
    val args: FilmDescribtionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_film_describtion, container, false)
        _binding = DataBindingUtil.bind(viewRoot)
        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = filmDescribtionViewModel
        initLiveData()
    }

    private fun initLiveData() {
        filmDescribtionViewModel.getFilmInfo(args.nameOfFilminfo)
    }
}