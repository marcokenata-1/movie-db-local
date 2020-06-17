package com.marcokenata.moviedatabase.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.marcokenata.moviedatabase.R
import com.marcokenata.moviedatabase.data.network.response.Result
import com.marcokenata.moviedatabase.databinding.ItemTicketBinding
import com.marcokenata.moviedatabase.ui.MovieDetails

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MultiViewHoler> {

    var context: Context? = null
    var listOfMovies =  ArrayList<Result>()
    var binding : ItemTicketBinding? = null


    constructor(context: Context?, listOfMovies : List<Result>){
        this.context = context
        this.listOfMovies = listOfMovies as ArrayList<Result>
    }

    class MultiViewHoler(view : View?) : RecyclerView.ViewHolder(view!!) {

        fun bind(result: Result){
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MovieDetails::class.java)
                intent.putExtra("movieId",result.id)
                intent.putExtra("movieTitle",result.originalTitle)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewHoler {
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflator, R.layout.item_ticket, null, false)
        return MultiViewHoler(binding?.root)
    }

    override fun getItemCount(): Int {
        return listOfMovies.size
    }

    override fun onBindViewHolder(holder: MultiViewHoler, position: Int) {
        binding?.movie = listOfMovies[position]
        holder.bind(listOfMovies[position])
    }
}