package com.example.redditassessment.model.repository

import com.example.redditassessment.model.ResponseData
import com.example.redditassessment.model.network.Network

class Repository: IRepository {
    sealed class DataState{
        class Data(val data: ResponseData?): DataState()
        class Error(val errMsg: String): DataState()
        object Loading: DataState()
    }

    override suspend fun getCharacters(page: Int): DataState {
        val response =
            Network.getInstance().getApi().getCharactersList()
        return if(response.isSuccessful)
            DataState.Data(response.body())
        else
            DataState.Error(response.message())
    }
}