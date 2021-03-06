package com.marcokenata.moviedatabase.ui.nowplaying

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcokenata.moviedatabase.data.network.response.DataResponse
import com.marcokenata.moviedatabase.data.repository.MovieRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class NowPlayingViewModel @Inject constructor(private var movieRepository: MovieRepository) : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val nowPlaying = MutableLiveData<DataResponse>()

    init {
        launch {
            nowPlaying.value = movieRepository.fetchNowPlayingMoviesRepo(1).value
        }
    }


}