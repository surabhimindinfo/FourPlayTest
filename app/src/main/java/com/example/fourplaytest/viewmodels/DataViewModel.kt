package com.example.fourplaytest.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fourplaytest.models.Article
import com.example.fourplaytest.repositories.DataRepositary
 import com.example.fourplaytest.utils.Utility.isInternetAvailable

class DataViewModel(private val context: Context) : ViewModel() {

    private var listData = MutableLiveData<ArrayList<Article>>()

    init{
        val userRepository : DataRepositary by lazy {
            DataRepositary
        }
        if(context.isInternetAvailable()) {
            listData = userRepository.getMutableLiveData(context)
        }
    }

    fun getData() : MutableLiveData<ArrayList<Article>>{
        return listData
    }

}