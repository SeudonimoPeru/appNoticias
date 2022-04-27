package com.jhon.data.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    // nos da la base de retrofit
    //se estructura toda la url brindada
    //"https://hn.algolia.com/api/v1/search_by_date?query=mobile"
    val URL = "https://hn.algolia.com/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}