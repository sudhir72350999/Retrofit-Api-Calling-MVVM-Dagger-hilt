package com.example.retrofitapicallingmvvm

import retrofit2.http.GET
import retrofit2.Call
interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>

}