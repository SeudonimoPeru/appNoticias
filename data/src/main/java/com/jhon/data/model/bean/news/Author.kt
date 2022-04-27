package com.jhon.data.model.bean.news

data class Author(
    var matchLevel: String = "",
    var matchedWords: List<Any> = listOf(),
    var value: String = ""
)