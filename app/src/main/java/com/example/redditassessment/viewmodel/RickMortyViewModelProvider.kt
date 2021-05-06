package com.example.redditassessment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.redditassessment.model.repository.IRepository

class RickMortyViewModelProvider(private val repository: IRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RickMortyViewModel(repository) as T
    }
}