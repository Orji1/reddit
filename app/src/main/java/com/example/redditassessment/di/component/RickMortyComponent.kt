package com.example.redditassessment.di.component

import com.example.redditassessment.di.modules.RepositoryModule
import com.example.redditassessment.di.modules.ViewModelProviderModule
import com.example.redditassessment.view.CharacterListFragment
import dagger.Component

@Component(modules = [RepositoryModule::class, ViewModelProviderModule::class])
interface RickMortyComponent {
    fun inject(fragment: CharacterListFragment)
}