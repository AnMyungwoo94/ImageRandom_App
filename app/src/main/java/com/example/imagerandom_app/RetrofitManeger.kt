package com.example.imagerandom_app

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//레트로핏 매니저
object RetrofitManeger {

    //okHttpClient 설정하기. kHttpClient는 안드로이드에서 HTTP 통신을 처리하는 클래스
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS) //서버와의 연결을 시도하는 최대 시간을 설정
        .readTimeout(5, TimeUnit.SECONDS) // 서버로부터 읽는 최대 시간을 설정
        .writeTimeout(5,TimeUnit.SECONDS) //서버로 쓰는 최대 시간을 설정
        .build()

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.unsplash.com/photos/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()

    val imageService: ImageService by lazy { retrofit.create(ImageService::class.java) }
}