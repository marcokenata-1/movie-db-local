package com.marcokenata.moviedatabase.viewmodeltest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.marcokenata.moviedatabase.data.db.MovieFavorites
import com.marcokenata.moviedatabase.data.repository.MovieRepository
import com.marcokenata.moviedatabase.ui.favorites.FavoritesViewModel
import com.marcokenata.moviedatabase.utils.CoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
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
class FavoritesViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = CoroutineRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var liveData : MutableLiveData<List<MovieFavorites>>



    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    fun testGetSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(liveData)
                .`when`(movieRepository)
                .favoriteList()
            val viewModel = FavoritesViewModel(movieRepository)
            assertTrue(viewModel.favorites.value == liveData.value)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }
}