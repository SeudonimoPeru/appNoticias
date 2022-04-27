package com.jhon.data.model.bean.news

data class StoryUrl(
    var matchLevel: String = "",
    var matchedWords: List<Any> = listOf(),
    var value: String = ""
)