package ru.ponomarevss.rickandmortyapi.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    @Expose val count: Int,
    @Expose val pages: Int,
    @Expose val next: String?,
    @Expose val prev: String?
): Parcelable