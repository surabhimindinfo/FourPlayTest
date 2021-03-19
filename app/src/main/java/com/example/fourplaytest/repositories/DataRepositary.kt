package com.example.fourplaytest.repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.fourplaytest.api.ApiClient
import com.example.fourplaytest.models.Article
import com.example.fourplaytest.models.ResponseClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepositary {

    fun getMutableLiveData(context: Context): MutableLiveData<ArrayList<Article>> {

        val mutableLiveData = MutableLiveData<ArrayList<Article>>()


        ApiClient.apiService.getNews().enqueue(object : Callback<ResponseClass> {


            override fun onFailure(call: Call<ResponseClass>, t: Throwable) {
                Log.e("error", t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseClass>, response: Response<ResponseClass>) {
                val usersResponse = response.body()?.articles
                usersResponse?.let { mutableLiveData.value = it as ArrayList<Article> }
            }

        })

        return mutableLiveData
    }

}