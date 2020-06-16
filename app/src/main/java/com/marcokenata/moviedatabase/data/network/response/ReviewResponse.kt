package com.marcokenata.moviedatabase.data.network.response

import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    val page: Int,
    val results: ArrayList<Review>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)