package com.example.redditassessment.di.modules

import com.example.redditassessment.model.repository.IRepository
import com.example.redditassessment.viewmodel.RickMortyViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class ViewModelProviderModule {
    @Provides
    fun provideViewModelProvider(repository: IRepository): RickMortyViewModelProvider{
        return RickMortyViewModelProvider(repository)
    }
}