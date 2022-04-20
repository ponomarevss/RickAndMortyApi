package ru.ponomarevss.rickandmortyapi.mvp.model.api

import retrofit2.http.GET
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.CharsRespond

interface IDataSource {

    @GET("character")
    suspend fun getChars(): CharsRespond
}