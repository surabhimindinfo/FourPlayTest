package com.example.fourplaytest.api

import com.example.fourplaytest.models.ResponseClass
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("top-headlines?country=us&category=business&apiKey=54012b475e174d7fb370f99b3bebd089")
    fun getNews(): Call<ResponseClass>

}