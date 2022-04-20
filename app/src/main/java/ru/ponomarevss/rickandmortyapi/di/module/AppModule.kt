package ru.ponomarevss.rickandmortyapi.di.module

import dagger.Module
import dagger.Provides
import ru.ponomarevss.rickandmortyapi.ui.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App = app
}