package com.jhon.data.model.bean.news

data class StoryTitle(
    var matchLevel: String = "",
    var matchedWords: List<Any> = listOf(),
    var value: String = ""
)