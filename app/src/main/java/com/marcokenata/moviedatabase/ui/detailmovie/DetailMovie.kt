package com.marcokenata.moviedatabase.ui.detailmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcokenata.moviedatabase.R
import com.marcokenata.moviedatabase.data.db.MovieFavorites
import com.marcokenata.moviedatabase.databinding.DetailMovieFragmentBinding
import com.marcokenata.moviedatabase.ui.adapter.ReviewAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.detail_movie_fragment.*
import javax.inject.Inject

class DetailMovie : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: DetailMovieViewModel

    lateinit var binding: DetailMovieFragmentBinding

    var adapter: ReviewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.detail_movie_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(DetailMovieViewModel::class.java)
        val movieId = activity?.intent?.extras?.get("movieId")
        viewModel.getMovieDetails(movieId as Int)
        viewModel.getReview(movieId)
        viewModel.checkFav(movieId)
        viewModel.details.observe(viewLifecycleOwner, Observer { res ->
            binding.mvDetail = res
            bt_adder.setOnClickListener {
                viewModel.addtoFav(MovieFavorites(movieId,res))
                bt_adder.visibility = View.GONE
                bt_remover.visibility = View.VISIBLE
            }
        })

        viewModel.reviews.observe(viewLifecycleOwner, Observer {
            adapter = ReviewAdapter(context, it.results)
            rv_movieReview.layoutManager = LinearLayoutManager(context)
            rv_movieReview.adapter = adapter
        })

        viewModel.favoriteCheck.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                bt_adder.visibility = View.VISIBLE
                bt_remover.visibility = View.GONE
            } else {
                bt_adder.visibility = View.GONE
                bt_remover.visibility = View.VISIBLE
            }
        })

        bt_remover.setOnClickListener {
            viewModel.removeFav(movieId)
            bt_adder.visibility = View.VISIBLE
            bt_remover.visibility = View.GONE
        }

    }

}