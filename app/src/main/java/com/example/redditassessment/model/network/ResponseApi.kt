package com.example.redditassessment.model.network

import com.example.redditassessment.BuildConfig
import com.example.redditassessment.model.ResponseData
import retrofit2.Response
import retrofit2.http.GET

interface ResponseApi {
    @GET(BuildConfig.END_POINT)
    suspend fun getCharactersList(): Response<ResponseData>
}