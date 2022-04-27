package com.jhon.data.model.bean.news

data class Url(
    var fullyHighlighted: Boolean = false,
    var matchLevel: String = "",
    var matchedWords: List<String> = listOf(),
    var value: String = ""
)