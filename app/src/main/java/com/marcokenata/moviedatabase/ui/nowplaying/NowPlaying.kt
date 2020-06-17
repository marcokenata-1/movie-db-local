package com.marcokenata.moviedatabase.ui.nowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
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

class NowPlaying : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: NowPlayingViewModel

    var adapter: MovieAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.now_playing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(NowPlayingViewModel::class.java)
        // TODO: Use the ViewModel

        viewModel.nowPlaying.observe(
            viewLifecycleOwner, Observer {
                adapter = MovieAdapter(context, it.results)
                rv_movie.layoutManager = LinearLayoutManager(context)
                rv_movie.adapter = adapter
            }
        )
    }

}