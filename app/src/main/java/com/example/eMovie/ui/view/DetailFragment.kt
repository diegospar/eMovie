package com.example.eMovie.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.eMovie.R
import com.example.eMovie.databinding.FragmentDetailBinding
import com.example.eMovie.ui.viewmodel.DetailViewModel
import java.util.Observer

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val detailViewModel: DetailViewModel by viewModels()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var poster: String
    private lateinit var title: String
    private lateinit var overview: String
    private lateinit var year: String
    private lateinit var language: String
    private lateinit var id: String
    private lateinit var rate: String
    private lateinit var genres: String



    private val postersURL = "https://image.tmdb.org/t/p/original"
    private var videoURL: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            poster = bundle.getString("poster")!!
            overview = bundle.getString("resume")!!
            title = bundle.getString("title")!!
            id= bundle.getString("id")!!
            rate=bundle.getString("rate")!!
            language= bundle.getString("language")!!
            year= bundle.getString("year")!!
            genres= bundle.getString("genres")!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        createVideoUrl(id)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       Glide.with(binding.imageView2.context).load(postersURL + poster).into(binding.imageView2)
        binding.apply {
            tvDescription.text = overview
            tvTitle.text = title
            tvYear.text = year
            tvLanguage.text = language
            tvRate.text = rate
            tvGens.text = genres
            backImage.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
            }
            tvTrailer.setOnClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(videoURL)
                startActivity(openURL)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding
    }

    fun createVideoUrl(movieID: String){
        val youtubeURL = "https://www.youtube.com/watch?v="
        detailViewModel.onCreate(movieID)
        detailViewModel.video.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
           videoURL = youtubeURL+ it.get(0).videoURL
        })
    }

}