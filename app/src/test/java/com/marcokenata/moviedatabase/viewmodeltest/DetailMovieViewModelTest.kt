package com.marcokenata.moviedatabase.viewmodeltest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.marcokenata.moviedatabase.data.db.MovieFavorites
import com.marcokenata.moviedatabase.data.network.response.Result
import com.marcokenata.moviedatabase.data.network.response.ReviewResponse
import com.marcokenata.moviedatabase.data.repository.MovieRepository
import com.marcokenata.moviedatabase.ui.detailmovie.DetailMovieViewModel
import com.marcokenata.moviedatabase.utils.CoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = CoroutineRule()

    private lateinit var viewModel: DetailMovieViewModel

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var liveData: MutableLiveData<ReviewResponse>

    @Mock
    private lateinit var liveDataDetails: MutableLiveData<Result>

    @Mock
    private lateinit var result: Result

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieRepository)
    }

    @Test
    fun testGetSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(liveData)
                .`when`(movieRepository)
                .fetchMovieReviewRepo(1)
            viewModel.getReview(1)
            assertTrue(viewModel.reviews.value == liveData.value)

            doReturn(liveDataDetails)
                .`when`(movieRepository)
                .fetchMovieDetailsRepo(1)

            viewModel.getMovieDetails(1)
            assertTrue(viewModel.details.value == liveDataDetails.value)
        }
    }

    @Test
    fun adder() {
        testCoroutineRule.run {
            val movieFavorites = MovieFavorites(1, result)
            viewModel.addtoFav(movieFavorites)
            viewModel.removeFav(1)
        }
    }
}