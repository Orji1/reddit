package com.example.redditassessment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterDetail(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: CharacterOrigin,
    val location: CharacterLocation,
    val image: String
): Parcelable