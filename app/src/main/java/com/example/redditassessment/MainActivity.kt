package com.example.redditassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.redditassessment.model.CharacterDetail
import com.example.redditassessment.view.CharacterDetailFragment
import com.example.redditassessment.view.CharacterListFragment

class MainActivity : AppCompatActivity(), CharacterListFragment.ShowCharacterDetails {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CharacterListFragment())
                .commit()
    }

    override fun showDetails(dataItem: CharacterDetail) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CharacterDetailFragment.newInstance(dataItem))
            .addToBackStack(null)
            .commit()
    }
}