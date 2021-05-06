package com.example.redditassessment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.redditassessment.R
import com.example.redditassessment.databinding.ItemLayoutBinding
import com.example.redditassessment.model.CharacterDetail
import com.example.redditassessment.model.ResponseData
import com.example.redditassessment.view.CharacterListFragment
import com.squareup.picasso.Picasso

class RickMortyAdapter(
    private var dataSet: ResponseData?,
    private val listener: CharacterListFragment.ShowCharacterDetails
) : RecyclerView.Adapter<RickMortyAdapter.RickMortyViewHolder>() {
    class RickMortyViewHolder(private val itemBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun onBind(
            dataItem: CharacterDetail,
            callback: CharacterListFragment.ShowCharacterDetails
        ) {
            val context = itemBinding.root.context
            Picasso.get().load(dataItem.image).into(itemBinding.ivCharacterPortrait)
            itemBinding.tvCharacterName.text = context.getString(
                R.string.character_name, dataItem.name
            )
            itemBinding.tvCharacterGender.text = context.getString(
                R.string.character_gender, dataItem.gender
            )
            itemBinding.tvCharacterLocation.text = context.getString(
                R.string.character_location, dataItem.location.name
            )

            itemBinding.root.setOnClickListener {
                callback.showDetails(dataItem)
            }
        }
    }

    fun updateDataSet(dataSet: ResponseData?) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        return RickMortyViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {
        dataSet?.results?.let {
            holder.onBind(it[position], listener)
        }
    }

    override fun getItemCount(): Int {
        return dataSet?.results?.size ?: 0
    }
}