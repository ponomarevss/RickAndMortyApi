package ru.ponomarevss.rickandmortyapi.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.ponomarevss.rickandmortyapi.mvp.model.navigation.IScreens
import ru.ponomarevss.rickandmortyapi.mvp.view.MainView
import javax.inject.Inject

class MainPresenter: MvpPresenter<MainView>() {

    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.chars())
    }

    fun backPressed() = router.exit()
}