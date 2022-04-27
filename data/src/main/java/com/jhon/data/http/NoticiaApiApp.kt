package com.jhon.data.http

import com.jhon.data.model.bean.HttpResponseNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NoticiaApiApp {

    // se lista todas las apis
    @GET("api/v1/search_by_date")
    suspend fun getAllNews(
        @Query("query") query: String
    ): Response<HttpResponseNews>

}