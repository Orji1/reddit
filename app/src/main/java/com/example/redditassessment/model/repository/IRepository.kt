package com.example.redditassessment.model.repository

interface IRepository {
    suspend fun getCharacters(page: Int): Repository.DataState
}