package com.example.imagerandom_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {

    @Headers("서버키")
    @GET("random")
    fun getRandomImage(): Call<ImageResponse>

}