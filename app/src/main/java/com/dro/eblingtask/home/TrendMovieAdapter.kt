package com.dro.eblingtask.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dro.eblingtask.R
import com.dro.eblingtask.databinding.ItemTrendMovieBinding
import com.dro.eblingtask.network.Urls
import kotlin.Result

class TrendMovieAdapter (
    val movieList: List<com.dro.eblingtask.home.Result>,
    val onMovieClickListener: OnMovieClickListener
) :
    RecyclerView.Adapter<TrendMovieAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendMovieAdapter.ViewHolder {

        var binding =
            ItemTrendMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            binding
        )


    }

    override fun onBindViewHolder(holder: TrendMovieAdapter.ViewHolder, position: Int) {

        holder.binding.trendmovie = movieList[position]
        holder.bindViews(position)

        holder.binding.root.setOnClickListener {
            onMovieClickListener.onMovieClicked(movieList[position])
        }

    }

    override fun getItemCount(): Int {
        return movieList.size

    }

    inner class ViewHolder(val binding: ItemTrendMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindViews(position: Int) {
            val movies = movieList[position]
            movies.let {
                val fullUrl = Urls.BASE_IMAGE_URL + it.poster_path
                Glide
                    .with(binding.root.context)
                    .load(fullUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.picImageview)
            }
        }

    }

    interface OnMovieClickListener {
        fun onMovieClicked(result: com.dro.eblingtask.home.Result)
    }


}