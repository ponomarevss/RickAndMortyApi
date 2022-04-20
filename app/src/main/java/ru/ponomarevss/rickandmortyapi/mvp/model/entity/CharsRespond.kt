package ru.ponomarevss.rickandmortyapi.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharsRespond(
    @Expose val info: Info,
    @Expose val results: List<Char>
): Parcelable
