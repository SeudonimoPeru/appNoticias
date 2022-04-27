package com.jhon.data.model.bean.news

data class News(
    var _highlightResult: HighlightResult = HighlightResult(),
    var _tags: List<String?> = listOf(),
    var author: String? = "",
    var comment_text: String? = "",
    var created_at: String? = "",
    var created_at_i: Int? = 0,
    var num_comments: Any? = Any(),
    var objectID: String = "",
    var parent_id: Int? = 0,
    var points: Any? = Any(),
    var story_id: Int? = 0,
    var story_text: Any? = Any(),
    var story_title: String? = "",
    var story_url: String? = "",
    var title: String? = "",
    var url: Any? = Any()
) {
    fun getURLValid(): String? {
        var validURL: String? = story_url
        if (validURL.isNullOrBlank()) {
            if (url is String) {
                validURL = url as String
            }
        }
        return validURL
    }
}