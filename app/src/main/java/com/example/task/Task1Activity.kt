package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task.model.MovieResponse
import com.example.task.model.ResultsItem
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class Task1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        var rf=  Retrofit.Builder()
            .baseUrl(MyApiCall.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var API = rf.create(MyApiCall::class.java)

        var call = API.movies

        call?.enqueue(object: Callback<List<ResultsItem?>?>{
            override fun onResponse(
                call: Call<List<ResultsItem?>?>,
                response: Response<List<ResultsItem?>?>
            ) {
                var movieList: List<ResultsItem>? = response.body() as List<ResultsItem>
                var movie = arrayOfNulls<String>(movieList!!.size)

                for(i in movieList!!.indices)
                {
                    //movie[i] = movieList!![i]!!
                }


            }


            override fun onFailure(call: Call<List<ResultsItem?>?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}