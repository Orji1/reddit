package com.example.redditassessment.model

data class ResponseData(
    val info: ResponsePage,
    var results: List<CharacterDetail>
)