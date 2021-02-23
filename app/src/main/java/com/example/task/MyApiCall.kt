package com.example.task

import com.example.task.model.MovieResponse
import com.example.task.model.ResultsItem
import retrofit2.Call
import retrofit2.http.GET

interface MyApiCall {
    @GET("3/movie/popular?api_key=ff828a72b45f8a8bc8835e4999ee3f6a")
    fun getMovieData(): Call<MovieResponse?>?
}