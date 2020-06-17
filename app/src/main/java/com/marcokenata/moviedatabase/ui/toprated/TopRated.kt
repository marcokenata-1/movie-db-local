package com.marcokenata.moviedatabase.ui.toprated

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
import com.marcokenata.moviedatabase.ui.adapter.MovieAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.popular_fragment.*
import javax.inject.Inject

class TopRated : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: TopRatedViewModel

    var adapter: MovieAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.top_rated_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TopRatedViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.topRated.observe(
            viewLifecycleOwner, Observer {
                adapter = MovieAdapter(context, it.results)
                rv_movie.layoutManager = LinearLayoutManager(context)
                rv_movie.adapter = adapter
            }
        )
    }

}