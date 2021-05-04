package com.aspiration.interview.data.network.service

import com.aspiration.interview.data.model.LatinMedia
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // TODO add your endpoint here

    @GET("posts")
    fun getData(): Call<LatinMedia>
}