package com.example.eMovie.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eMovie.R
import com.example.eMovie.data.model.MovieModel

class UpcomingAdapter(val moviesList:List<MovieModel>, private val onClickListener: (MovieModel) -> Unit):
    RecyclerView.Adapter<UpcomingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UpcomingViewHolder(layoutInflater.inflate(R.layout.item_poster,parent, false))
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        var item = moviesList[position]
        holder.render(item,onClickListener)
    }

    override fun getItemCount(): Int = moviesList.size

}