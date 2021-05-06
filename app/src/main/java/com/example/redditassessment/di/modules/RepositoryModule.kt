package com.example.redditassessment.di.modules

import com.example.redditassessment.model.repository.IRepository
import com.example.redditassessment.model.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesRepository(): IRepository {
        return Repository()
    }
}