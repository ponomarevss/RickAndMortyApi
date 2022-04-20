package ru.ponomarevss.rickandmortyapi.mvp.model.api

import retrofit2.http.GET
import retrofit2.http.Url
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.Char
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.CharsRespond

interface IDataSource {

    @GET("character")
    suspend fun getChars(): CharsRespond

    @GET
    suspend fun getChar(@Url url: String): Char
}