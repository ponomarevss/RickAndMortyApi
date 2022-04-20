package ru.ponomarevss.rickandmortyapi.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    @Expose val name: String,
    @Expose val url: String
): Parcelable