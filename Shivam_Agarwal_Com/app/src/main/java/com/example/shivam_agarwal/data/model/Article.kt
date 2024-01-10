package com.example.shivam_agarwal.data.model

data class Article(
    val publishedAt: String = "",
    val author: String = "",
    val urlToImage: String = "",
    val description: String = "",
    val source: Source,
    val title: String = "",
    val url: String = "",
    val content: String = ""
)


data class Source(
    val name: String = "",
    val id: String = ""
)
