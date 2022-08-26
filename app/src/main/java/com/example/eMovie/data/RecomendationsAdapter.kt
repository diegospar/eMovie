package com.example.eMovie.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eMovie.R
import com.example.eMovie.data.model.MovieModel

class RecomendationsAdapter(val moviesList:List<MovieModel>, private val onClickListener: (MovieModel) -> Unit):
    RecyclerView.Adapter<RecomendationsViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomendationsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RecomendationsViewHolder(layoutInflater.inflate(R.layout.item_recomendations_poster,parent, false))
    }

    override fun onBindViewHolder(holder: RecomendationsViewHolder, position: Int) {
        var item = moviesList[position]
        holder.render(item,onClickListener)
    }

    override fun getItemCount(): Int = moviesList.size
}