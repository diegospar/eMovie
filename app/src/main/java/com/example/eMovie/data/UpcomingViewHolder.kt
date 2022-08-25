package com.example.eMovie.data

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eMovie.data.model.MovieModel
import com.example.eMovie.databinding.FragmentHomeBinding
import com.example.eMovie.databinding.ItemPosterBinding

class UpcomingViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemPosterBinding.bind(view)
    val postersURL = "https://image.tmdb.org/t/p/original"

    fun render(movie:MovieModel,onClickListener:(MovieModel) -> Unit){
        binding.apply {
            Glide.with(poster.context).load(postersURL + movie.poster).into(poster)
            itemView.setOnClickListener { onClickListener(movie) }
        }
    }
}