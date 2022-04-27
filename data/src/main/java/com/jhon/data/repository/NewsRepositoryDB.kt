package com.jhon.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.jhon.data.room.NewsDataBase
import com.jhon.data.room.entity.RoomNews

class NewsRepositoryDB(context: Context) {
    // repo de bd
    private val daoNews by lazy { NewsDataBase.getDatabase(context).DaoNews() }

    fun insertNews(news: List<RoomNews>) {
        daoNews.deleteAll()
        daoNews.insert(news)
    }

    fun getNewsLiveData(): LiveData<List<RoomNews>> {
        return daoNews.liveDataList
    }

    fun getNews(): List<RoomNews> {
        return daoNews.list
    }

    fun updateVisibilyty(objectID: String) {
        daoNews.updateVisibiilty(objectID)
    }
}