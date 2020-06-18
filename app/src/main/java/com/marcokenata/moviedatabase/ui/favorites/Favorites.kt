package com.marcokenata.moviedatabase.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcokenata.moviedatabase.R
import com.marcokenata.moviedatabase.ui.adapter.MovieDBAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.favorites_fragment.*
import javax.inject.Inject

class Favorites : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FavoritesViewModel

    var adapter: MovieDBAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorites_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FavoritesViewModel::class.java)

        viewModel.favorites.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) {
                tv_noFavs.visibility = View.VISIBLE
            } else {
                tv_noFavs.visibility = View.GONE
                adapter = MovieDBAdapter(context, it)
                rv_movie.layoutManager = LinearLayoutManager(context)
                rv_movie.adapter = adapter
            }
        })
    }

}