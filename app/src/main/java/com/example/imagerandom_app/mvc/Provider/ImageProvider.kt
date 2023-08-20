package com.example.imagerandom_app.mvc.Provider

import android.telecom.Call
import com.example.imagerandom_app.ImageResponse
import com.example.imagerandom_app.RetrofitManeger
import retrofit2.Response
import retrofit2.Retrofit

//이미지를 불러오는 클래스
class ImageProvider(private val callback : Callback) {

    fun getRandomImage(){
        RetrofitManeger.imageService.getRandomImage()
            .enqueue(object  : retrofit2.Callback<ImageResponse>{
                override fun onResponse(
                    call: retrofit2.Call<ImageResponse>,
                    response: Response<ImageResponse>
                ) {
                   if(response.isSuccessful){
                       response.body()?.let {
                           callback.loadImage(it.urls.regular, it.color)
                       }
                   }
                }
                override fun onFailure(call: retrofit2.Call<ImageResponse>, t: Throwable) {
                }
            })
    }

    //이미지를 불러오고, 그 이미지를 바깥쪽에 반환해줌
    interface Callback{
        fun loadImage(url: String, color: String)
    }

}