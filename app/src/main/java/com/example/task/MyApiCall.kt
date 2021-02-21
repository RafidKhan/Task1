package com.example.task

import com.example.task.model.MovieResponse
import com.example.task.model.ResultsItem
import retrofit2.Call
import retrofit2.http.GET

interface MyApiCall {

    @get:GET("3/movie/popular")
    val movies: Call<List<ResultsItem?>?>?

    companion object {
        val BASE_URL = "http://api.themoviedb.org/"
    }
}