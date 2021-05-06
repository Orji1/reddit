package com.example.redditassessment.model

data class ResponsePage(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)