package com.jhon.domain

import android.content.Context
import com.jhon.data.repository.NewsRepositoryAPI
import com.jhon.data.repository.NewsRepositoryDB

class NewsUseCase(context: Context) {
    //caso de uso traer noticia , se escoge el repo de donde se traera
    val repoOnline = NewsRepositoryAPI()
    val repoDB = NewsRepositoryDB(context)
}