package com.jhon.appnoticias.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jhon.data.model.dto.MapperClientImpl
import com.jhon.domain.NewsUseCase
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {

    var newsUseCase = NewsUseCase(application)

    val lstNewsLiveData = newsUseCase.repoDB.getNewsLiveData()
    val isOffline = MutableLiveData<Boolean>()

    fun loadNews() {
        //COROUTINE
        viewModelScope.launch {


            runCatching {
                //solicita noticia de servicio
                newsUseCase.repoOnline.getNews()
            }.onSuccess {
                it?.let {
                    //lo consigue
                    val data = it.hits
                    val datax = MapperClientImpl().toListEntity(data)
                    //guardo en local
                    newsUseCase.repoDB.insertNews(datax)
                    isOffline.postValue(false)
                }
            }.onFailure {
                //falla
                isOffline.postValue(true)
            }

        }
    }

    //actualizo flag , ya no puedo ver esa noticia
    fun updateVisibilityDB(objectID: String) {
        newsUseCase.repoDB.updateVisibilyty(objectID)
    }


}
