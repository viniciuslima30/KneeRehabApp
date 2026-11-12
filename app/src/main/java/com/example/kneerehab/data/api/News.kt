
package com.example.kneerehab.data.api

data class NewsResponse(
    val articles: List<NewsArticle>
)

data class NewsArticle(
    val title: String,
    val description: String?,
    val url: String,
    val image: String?,
    val publishedAt: String,
    val source: NewsSource
)

data class NewsSource(
    val name: String
)
