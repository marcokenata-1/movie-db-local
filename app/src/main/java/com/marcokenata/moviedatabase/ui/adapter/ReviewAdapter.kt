package com.marcokenata.moviedatabase.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.marcokenata.moviedatabase.R
import com.marcokenata.moviedatabase.data.network.response.Review
import com.marcokenata.moviedatabase.databinding.ReviewTicketBinding

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.MultiViewHoler> {

    var context: Context? = null
    var listOfReview = ArrayList<Review>()
    var binding: ReviewTicketBinding? = null

    constructor(context: Context?,listOfReview: List<Review>){
        this.context = context
        this.listOfReview = listOfReview as ArrayList<Review>
    }

    class MultiViewHoler(view: View?) : RecyclerView.ViewHolder(view!!) {
        fun bind(review: Review) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewHoler {
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflator, R.layout.review_ticket, null, false)
        return MultiViewHoler(binding?.root)
    }

    override fun getItemCount(): Int {
        return listOfReview.size
    }

    override fun onBindViewHolder(holder: MultiViewHoler, position: Int) {
        binding?.review = listOfReview[position]
        holder.bind(listOfReview[position])
    }
}