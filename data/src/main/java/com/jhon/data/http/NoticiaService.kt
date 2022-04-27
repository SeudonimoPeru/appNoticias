package com.jhon.data.http

import com.jhon.data.model.bean.HttpResponseNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoticiasService {
    private val retrofit = RetrofitHelper.getRetrofit()
    //metodo que será llamado en segundo plano
    suspend fun getNews(): HttpResponseNews? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(NoticiaApiApp::class.java).getAllNews("mobile")
            response.body()
        }
    }
}