package com.example.redditassessment

import android.app.Application
import com.example.redditassessment.di.component.DaggerRickMortyComponent
import com.example.redditassessment.di.component.RickMortyComponent
import com.example.redditassessment.di.modules.RepositoryModule
import com.example.redditassessment.di.modules.ViewModelProviderModule

class RickMortyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerRickMortyComponent.builder()
            .repositoryModule(RepositoryModule())
            .viewModelProviderModule(ViewModelProviderModule())
            .build()
    }

    companion object{
        lateinit var component: RickMortyComponent
    }
}