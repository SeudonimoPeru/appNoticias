package com.jhon.data.model.bean.news

data class HighlightResult(
    var author: Author = Author(),
    var comment_text: CommentText = CommentText(),
    var story_title: StoryTitle = StoryTitle(),
    var story_url: StoryUrl = StoryUrl(),
    var title: Title = Title(),
    var url: Url = Url()
)