package com.jhon.data.model.bean

import com.jhon.data.model.bean.news.News
//response http
//atributos y data class se crean
data class HttpResponseNews(
    var exhaustiveNbHits: Boolean = false,
    var exhaustiveTypo: Boolean = false,
    var hits: List<News> = listOf(),
    var hitsPerPage: Int = 0,
    var nbHits: Int = 0,
    var nbPages: Int = 0,
    var page: Int = 0,
    var params: String = "",
    var processingTimeMS: Int = 0,
    var query: String = ""
)