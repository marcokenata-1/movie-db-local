package com.marcokenata.moviedatabase.data.converters

import androidx.room.TypeConverter
import com.example.movieappv2.data.network.response.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {

    @TypeConverter
    @JvmStatic
    fun resultToString(result: Result): String {
        val gson = Gson()
        return gson.toJson(Result)
    }

    @TypeConverter
    @JvmStatic
    fun stringToResult(value: String): Result {
        val listType = object : TypeToken<Result>() {

        }.type
        return Gson().fromJson(value, listType)
    }
}