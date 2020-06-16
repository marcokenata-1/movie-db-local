package com.example.movieappv2.data.network.response


import com.google.gson.annotations.SerializedName

data class DataResponse(
    val page: Int,
    val results: ArrayList<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)