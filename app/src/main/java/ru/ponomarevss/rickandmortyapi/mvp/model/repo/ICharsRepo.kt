package ru.ponomarevss.rickandmortyapi.mvp.model.repo

import ru.ponomarevss.rickandmortyapi.mvp.model.entity.CharsRespond

interface ICharsRepo {
    suspend fun getCharsRespond(): CharsRespond
}