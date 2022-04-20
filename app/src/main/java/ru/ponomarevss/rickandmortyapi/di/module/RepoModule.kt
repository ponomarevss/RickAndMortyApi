package ru.ponomarevss.rickandmortyapi.di.module

import dagger.Module
import dagger.Provides
import ru.ponomarevss.rickandmortyapi.mvp.model.api.IDataSource
import ru.ponomarevss.rickandmortyapi.mvp.model.repo.ICharsRepo
import ru.ponomarevss.rickandmortyapi.mvp.model.repo.RetrofitCharsRepo
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun filmsRepo(
        api: IDataSource,
    ): ICharsRepo = RetrofitCharsRepo(api)

}