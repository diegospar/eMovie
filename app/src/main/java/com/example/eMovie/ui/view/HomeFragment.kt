package com.example.eMovie.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eMovie.R
import com.example.eMovie.data.RecomendationsAdapter
import com.example.eMovie.data.UpcomingAdapter
import com.example.eMovie.data.model.GenreModel
import com.example.eMovie.data.model.MovieModel
import com.example.eMovie.databinding.FragmentHomeBinding
import com.example.eMovie.domain.GetVideoUseCase
import com.example.eMovie.ui.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var listOfGenres : List<GenreModel>? = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.onCreate()

        homeViewModel.apply {
            category1IsLoading.observe(viewLifecycleOwner, Observer {
                binding.pbCategory1.isVisible = it
            })
            category2IsLoading.observe(viewLifecycleOwner, Observer {
                binding.pbCategory2.isVisible = it
            })
            category3IsLoading.observe(viewLifecycleOwner, Observer {
                binding.pbCategory3.isVisible = it
            })
            topRatedMovies.observe(viewLifecycleOwner, Observer { topRatedMovies ->
                initRecyclerView(topRatedMovies, binding.rvCategory2)
            })
            upcomingMovies.observe(viewLifecycleOwner, Observer { upcomingMovies ->
                initRecyclerView(upcomingMovies, binding.rvCategory1)
            })
            moviesByLanguage.observe(viewLifecycleOwner, Observer { movies ->
                initRecomendationsRecyclerView(movies, binding.rvCategory3)
            })
            moviesByDate.observe(viewLifecycleOwner, Observer { movies ->
                initRecomendationsRecyclerView(movies, binding.rvCategory4)
            })
            binding.chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
                if (checkedIds[0]==binding.chip5.id){
                    rvCategory3.visibility = GONE
                    rvCategory4.visibility = VISIBLE
                }else{
                    rvCategory4.visibility = GONE
                    rvCategory3.visibility = VISIBLE
                }
            }
            genres.observe(viewLifecycleOwner, Observer { genres ->
                listOfGenres = genres
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
        val bundle = bundleOf()
        prepareBundle(bundle, movieModel)
        findNavController().navigate(R.id.detailFragment, bundle)
    }

    override fun onResume() {
        super.onResume()
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
            genres.observe(viewLifecycleOwner, Observer { genres ->
                listOfGenres = genres
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding
    }

    fun prepareBundle (bundle: Bundle,movieModel: MovieModel){
        bundle.putString("language" ,  movieModel.language)
        bundle.putString("title" ,  movieModel.title)
        bundle.putString("resume" ,  movieModel.description)
        bundle.putString("year" ,  movieModel.date.substring(0,4))
        bundle.putString("id" , movieModel.id )
        bundle.putString("rate" ,  movieModel.average)
        bundle.putString("poster", movieModel.poster)
        val genres = getGenres(movieModel.genres)
        bundle.putString("genres", genres )
    }

    fun getGenres(movieGenres: List<Int>):String{
        var genres: String = ""

            movieGenres?.forEach(){ genreId ->
                listOfGenres?.forEach {
                    if(it.id== genreId.toString()){
                        if (genres.isNullOrEmpty()){
                            genres += it.genreName
                        }else genres += " • " + it.genreName
                    }
                }
            }

        return genres
    }



}