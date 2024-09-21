package com.example.retrofitapicallingmvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
//    private val _posts = MutableLiveData<List<Post>>()
//    val posts: MutableLiveData<List<Post>> = MutableLiveData()
//    val posts: LiveData<List<Post>> = _posts

    val posts: MutableLiveData<List<Post>> = MutableLiveData()

    fun fetchPosts() {
        // Simulating an API call, replace this with actual Retrofit call
        apiService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    posts.value = response.body()  // Update LiveData with the response
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // Handle failure
            }
        })
    }

}

