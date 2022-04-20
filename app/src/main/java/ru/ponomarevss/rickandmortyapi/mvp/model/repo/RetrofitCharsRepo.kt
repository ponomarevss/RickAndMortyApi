package ru.ponomarevss.rickandmortyapi.mvp.model.repo

import kotlinx.coroutines.withTimeout
import ru.ponomarevss.rickandmortyapi.mvp.model.api.IDataSource
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.Char
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.CharsRespond
import java.io.IOException

class RetrofitCharsRepo(val api: IDataSource) : ICharsRepo {

    override suspend fun getCharsRespond(): CharsRespond {
        try {
            val result = withTimeout(5_000) {
                api.getChars()
            }
            return result
        } catch (e: Throwable) {
            throw IOException("Unable to fetch chars respond", e)
        }
    }

    override suspend fun getChar(url: String): Char {
        try {
            val result = withTimeout(5_000) {
                api.getChar(url)
            }
            return result
        } catch (e: Throwable) {
            throw IOException("Unable to fetch char", e)
        }
    }
}