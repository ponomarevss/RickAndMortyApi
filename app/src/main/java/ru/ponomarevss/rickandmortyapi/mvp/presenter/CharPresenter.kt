package ru.ponomarevss.rickandmortyapi.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.Char
import ru.ponomarevss.rickandmortyapi.mvp.view.CharView
import javax.inject.Inject

class CharPresenter(val char: Char) : MvpPresenter<CharView>() {

    @Inject lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setTitle(char.name)
        viewState.setStatus(char.status)
        viewState.setSpecies(char.species)
        viewState.setGender(char.gender)
        viewState.setOriginName(char.origin.name)
        viewState.setLocationName(char.location.name)
        viewState.setCreated(char.created)
        viewState.loadImage(char.image)
        viewState.setHomeButton()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}