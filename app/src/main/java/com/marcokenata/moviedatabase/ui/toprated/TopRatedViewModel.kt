package com.marcokenata.moviedatabase.ui.toprated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcokenata.moviedatabase.data.network.response.DataResponse
import com.marcokenata.moviedatabase.data.repository.MovieRepository
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class TopRatedViewModel @Inject constructor(private var movieRepository: MovieRepository) : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val topRated = MutableLiveData<DataResponse>()

    init {
        launch {
            topRated.value = movieRepository.fetchTopRatedMoviesRepo(1).value
        }
    }
}