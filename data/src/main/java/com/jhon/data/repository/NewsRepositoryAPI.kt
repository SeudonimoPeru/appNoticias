package com.jhon.data.repository

import com.jhon.data.http.NoticiasService
import com.jhon.data.model.bean.HttpResponseNews

class NewsRepositoryAPI {
    //repo de http
    private val api by lazy { NoticiasService() }

    suspend fun getNews(): HttpResponseNews? {
        return api.getNews()
    }

}