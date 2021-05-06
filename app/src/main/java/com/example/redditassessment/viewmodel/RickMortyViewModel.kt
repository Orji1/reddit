package com.example.redditassessment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redditassessment.model.repository.IRepository
import com.example.redditassessment.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RickMortyViewModel(private val repository: IRepository): ViewModel() {
    private val mutableLiveData = MutableLiveData<Repository.DataState>()
    val liveData: LiveData<Repository.DataState> = mutableLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val data= repository.getCharacters(1)
            withContext(Dispatchers.Main){
                mutableLiveData.value = Repository.DataState.Loading
                delay(1000)
                mutableLiveData.value = data
            }
        }
    }
}