package com.example.eMovie.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.eMovie.databinding.FragmentHomeBinding
import com.example.eMovie.ui.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeViewModel.onCreate()

        homeViewModel.apply {
            category1IsLoading.observe(this@HomeFragment, Observer {
                binding.pbCategory1.isVisible = it
            })
            category2IsLoading.observe(this@HomeFragment, Observer {
                binding.pbCategory2.isVisible = it
            })
            topRatedMovies.observe(this@HomeFragment, Observer { currentMovie ->

            })
            upcomingMovies.observe(this@HomeFragment, Observer { currentMovie ->

            })
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
}