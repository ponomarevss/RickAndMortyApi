package ru.ponomarevss.rickandmortyapi.di

import dagger.Component
import ru.ponomarevss.rickandmortyapi.di.module.ApiModule
import ru.ponomarevss.rickandmortyapi.di.module.AppModule
import ru.ponomarevss.rickandmortyapi.di.module.CiceroneModule
import ru.ponomarevss.rickandmortyapi.di.module.RepoModule
import ru.ponomarevss.rickandmortyapi.mvp.presenter.CharPresenter
import ru.ponomarevss.rickandmortyapi.mvp.presenter.CharsPresenter
import ru.ponomarevss.rickandmortyapi.mvp.presenter.MainPresenter
import ru.ponomarevss.rickandmortyapi.ui.activity.MainActivity
import ru.ponomarevss.rickandmortyapi.ui.fragment.CharsFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        CiceroneModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(charsPresenter: CharsPresenter)
    fun inject(charPresenter: CharPresenter)
}