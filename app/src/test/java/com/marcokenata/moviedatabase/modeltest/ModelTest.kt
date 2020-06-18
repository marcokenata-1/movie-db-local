package com.marcokenata.moviedatabase.modeltest

import com.marcokenata.moviedatabase.data.network.response.DataResponse
import com.marcokenata.moviedatabase.data.network.response.Result
import com.marcokenata.moviedatabase.data.network.response.Review
import com.marcokenata.moviedatabase.data.network.response.ReviewResponse
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ModelTest {

    private lateinit var res : Result

    private lateinit var res1 : Result

    private lateinit var a : Review

    private lateinit var b : Review

    @Test
    fun dataResponseComparer(){
        val arrayList: ArrayList<Result> =
            ArrayList()
        val genreId: ArrayList<Int> = ArrayList()
        res = Result("a", genreId, 1, "a", "a", "a", "a", "a", "a", 100.0, 9)
        res1 = Result("a", genreId, 2, "a", "a", "a", "a", "a", "a", 100.0, 9)
        genreId.add(1)
        genreId.add(2)
        arrayList.add(res)
        arrayList.add(res1)
        val x = DataResponse(1,arrayList,10,100)
        val y = DataResponse(1,arrayList,11,100)
        assertFalse(x == y)
    }

    @Test
    fun resultComparer() {
        val genreId: ArrayList<Int> = ArrayList()
        res = Result("a", genreId, 1, "a", "a", "a", "a", "a", "a", 100.0, 9)
        res1 = Result("a", genreId, 2, "a", "a", "a", "a", "a", "a", 100.0, 9)
        genreId.add(1)
        genreId.add(2)
        assertFalse(res == res1)
    }

    @Test
    fun reviewComparer(){
        val a = Review("a","test","test","test")
        val b = Review("a","test","test","test")
        assertTrue(a == b)
    }

    @Test
    fun reviewResponseComparer(){
        val arrayList: ArrayList<Review> =
            ArrayList()
        val a = Review("a","test","test","test")
        val b = Review("a","test","test","test")
        arrayList.add(a)
        arrayList.add(b)

        val v = ReviewResponse(1,arrayList,10,11)
        val w = ReviewResponse(2,arrayList,10,11)

        assertFalse(v == w)
    }



}