package com.example.task

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.databinding.ActivityTask1Binding
import com.example.task.model.MovieResponse
import com.example.task.model.ResultsItem
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class Task1Activity : AppCompatActivity() {
    val BASE_URL = "http://api.themoviedb.org/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)

        val binding = ActivityTask1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val mRecyclerView: RecyclerView? = null

        var client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)


        var rf = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()

        var API = rf.create(MyApiCall::class.java)

        var call = API.getMovieData()

        call?.enqueue(object : Callback<MovieResponse?> {
            override fun onResponse(

                call: Call<MovieResponse?>,
                response: Response<MovieResponse?>
            ) {

                var movieList = response
                var adapterImage: ImageAdapter =
                    ImageAdapter(movieList.body()?.results!!, applicationContext)

                Log.d("OnResponse", movieList.code().toString() +" "+movieList.message())
                binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                binding.recyclerView.adapter = adapterImage
                binding.recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<MovieResponse?>, t: Throwable) {
                Log.d("OnResponse", t.message.toString())
            }
        })
    }
}