package com.jhon.data.model.bean.news

data class Title(
    var fullyHighlighted: Boolean = false,
    var matchLevel: String = "",
    var matchedWords: List<String> = listOf(),
    var value: String = ""
)