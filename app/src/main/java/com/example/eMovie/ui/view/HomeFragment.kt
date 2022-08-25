package com.example.eMovie.ui.view

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eMovie.data.RecomendationsAdapter
import com.example.eMovie.data.UpcomingAdapter
import com.example.eMovie.data.model.MovieModel
import com.example.eMovie.databinding.FragmentHomeBinding
import com.example.eMovie.ui.viewmodel.HomeViewModel
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


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
            category3IsLoading.observe(this@HomeFragment, Observer {
                binding.pbCategory3.isVisible = it
            })
            topRatedMovies.observe(this@HomeFragment, Observer { topRatedMovies ->
                initRecyclerView(topRatedMovies, binding.rvCategory2)
            })
            upcomingMovies.observe(this@HomeFragment, Observer { upcomingMovies ->
                initRecyclerView(upcomingMovies, binding.rvCategory1)
            })
            moviesByLanguage.observe(this@HomeFragment, Observer { movies ->
                initRecomendationsRecyclerView(movies, binding.rvCategory3)
                binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
                    if (checkedIds[0]==binding.chip5.id){
                        rvCategory3.visibility = GONE
                        rvCategory4.visibility = VISIBLE
                    }else{
                        rvCategory4.visibility = GONE
                        rvCategory3.visibility = VISIBLE
                    }
                }
            })
            moviesByDate.observe(this@HomeFragment, Observer { movies ->
                initRecomendationsRecyclerView(movies, binding.rvCategory4)
                binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
                }
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

    fun initRecyclerView(movies:List<MovieModel>, recycler: RecyclerView){
        val recyclerView = recycler
        recyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = UpcomingAdapter(movies){
            onPosterSelected(it)
        }
    }

    fun initRecomendationsRecyclerView(movies:List<MovieModel>, recycler: RecyclerView){
        val recyclerView = recycler
        recyclerView.layoutManager = GridLayoutManager(this@HomeFragment.context,2, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = RecomendationsAdapter(movies){
            onPosterSelected(it)
        }
    }

    fun onPosterSelected(movieModel: MovieModel){
        Toast.makeText(context, movieModel.title, Toast.LENGTH_SHORT).show()
    }
}