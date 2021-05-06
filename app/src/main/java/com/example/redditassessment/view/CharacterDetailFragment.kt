package com.example.redditassessment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.redditassessment.R
import com.example.redditassessment.databinding.CharacterDetailsFragmentBinding
import com.example.redditassessment.model.CharacterDetail
import com.squareup.picasso.Picasso

class CharacterDetailFragment: Fragment() {
    companion object{
        const val EXTRA_DATA_CHARACTER = "CharacterDetailFragment_EXTRA_DATA"

        fun newInstance(details: CharacterDetail): CharacterDetailFragment{
            return CharacterDetailFragment().apply {
                arguments =
                    Bundle().apply {
                        putParcelable(EXTRA_DATA_CHARACTER, details)
                    }
            }
        }
    }

    private lateinit var binding: CharacterDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = CharacterDetailsFragmentBinding.inflate(inflater)
        arguments?.let { initViews(it) }
        return binding.root
    }

    private fun initViews(dataItem: Bundle) {
        dataItem.getParcelable<CharacterDetail>(EXTRA_DATA_CHARACTER)?.let {
            binding.tvCharacterDetailName.text = context?.getString(
                R.string.character_name, it.name)
            binding.tvCharacterDetailGender.text = context?.getString(
                R.string.character_gender, it.gender )
            binding.tvCharacterDetailLocation.text = context?.getString(
                R.string.character_location, it.location.name)
            binding.tvCharacterDetailOrigin.text = context?.getString(
                R.string.character_origin, it.origin.name)
            binding.tvCharacterDetailSpecies.text = context?.getString(
                R.string.character_species, it.species)
            binding.tvCharacterDetailStatus.text = context?.getString(
                R.string.character_status, it.status)
            Picasso.get().load(it.image).into(binding.ivCharacterDetails)
        }
    }
}