package ru.ponomarevss.rickandmortyapi.ui

import android.app.Application
import ru.ponomarevss.rickandmortyapi.di.AppComponent
import ru.ponomarevss.rickandmortyapi.di.DaggerAppComponent

class App: Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .build()
    }
}