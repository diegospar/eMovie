package com.example.eMovie.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.eMovie.databinding.ActivityMainBinding
import com.example.eMovie.ui.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val moviesViewModel:MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        moviesViewModel.onCreate()

        moviesViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        moviesViewModel.topRatedMovies.observe(this, androidx.lifecycle.Observer { currentMovie ->
            binding.tvTipo.text = currentMovie[0].language
            binding.tvDireccion.text = currentMovie[0].date
        })



    }


}