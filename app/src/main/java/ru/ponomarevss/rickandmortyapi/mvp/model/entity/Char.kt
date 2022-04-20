package ru.ponomarevss.rickandmortyapi.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Char(
    @Expose val id: Int,
    @Expose val name: String,
    @Expose val status: String,
    @Expose val species: String,
    @Expose val type: String,
    @Expose val gender: String,
    @Expose val origin: Location,
    @Expose val location: Location,
    @Expose val image: String,
    @Expose val url: String,
    @Expose val created: String
): Parcelable