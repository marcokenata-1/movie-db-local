package com.marcokenata.moviedatabase.data.converters

import androidx.room.TypeConverter
import com.marcokenata.moviedatabase.data.network.response.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {

    @TypeConverter
    @JvmStatic
    fun resultToString(result: Result): String {
        val gson = Gson()
        return gson.toJson(result)
    }

    @TypeConverter
    @JvmStatic
    fun stringToResult(value: String): Result {
        val listType = object : TypeToken<Result>() {

        }.type
        return Gson().fromJson(value, listType)
    }
}