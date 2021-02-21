package com.example.task

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.task.model.ResultsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Task1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        val mRecyclerView: RecyclerView? = null

        var rf=  Retrofit.Builder()
            .baseUrl(MyApiCall.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var API = rf.create(MyApiCall::class.java)

        var call = API.movies

        call?.enqueue(object : Callback<List<ResultsItem?>?> {
            override fun onResponse(
                call: Call<List<ResultsItem?>?>,
                response: Response<List<ResultsItem?>?>
            ) {
                var movieList: List<ResultsItem>? = response.body() as List<ResultsItem>
                var movie = arrayOfNulls<String>(movieList!!.size)

                for (i in movieList!!.indices) {
                    movie[i] = movieList!![i]!!.title
                    movie[i] = movieList!![i]!!.posterPath
                    movie[i] = movieList!![i]!!.overview

                }

                var adapter = ArrayAdapter<String>(applicationContext, R.layout.movie_items, movie)




            }


            override fun onFailure(call: Call<List<ResultsItem?>?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}