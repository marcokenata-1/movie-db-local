package com.marcokenata.moviedatabase.adaptertest

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcokenata.moviedatabase.data.network.response.Result
import com.marcokenata.moviedatabase.ui.adapter.MovieAdapter
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TestAdapter {

    private lateinit var adapter: MovieAdapter

    private lateinit var res : Result

    private lateinit var res1 : Result

    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var viewGroup: ViewGroup

    @Mock
    private lateinit var viewHolder: MovieAdapter.MultiViewHoler

    @Before
    fun setUp() {
        val arrayList: ArrayList<Result> =
            ArrayList()
        val genreId: ArrayList<Int> = ArrayList()
        res = Result("a", genreId, 1, "a", "a", "a", "a", "a", "a", 100.0, 9)
        res1 = Result("a", genreId, 2, "a", "a", "a", "a", "a", "a", 100.0, 9)
        genreId.add(1)
        genreId.add(2)
        arrayList.add(res)
        arrayList.add(res1)
        adapter = MovieAdapter(context,arrayList)
    }

    @Test
    fun itemCount(){
        assertEquals(adapter.itemCount,2)
    }

    @Test
    fun onBindViewHolder(){
        assertFalse(adapter.onBindViewHolder(viewHolder, 0) == null)
    }
}