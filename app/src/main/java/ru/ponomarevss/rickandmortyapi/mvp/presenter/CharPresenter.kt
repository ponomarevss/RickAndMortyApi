package ru.ponomarevss.rickandmortyapi.mvp.presenter

import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.runBlocking
import moxy.MvpPresenter
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.Char
import ru.ponomarevss.rickandmortyapi.mvp.model.repo.ICharsRepo
import ru.ponomarevss.rickandmortyapi.mvp.view.CharView
import javax.inject.Inject

class CharPresenter(private val charUrl: String) : MvpPresenter<CharView>() {

    @Inject lateinit var router: Router
    @Inject lateinit var repo: ICharsRepo

    private var char: Char? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        with(viewState) {
            char?.let { setTitle(it.name) } ?: setTitle("")
            char?.let { setStatus(it.status) } ?: setStatus("")
            char?.let { setSpecies(it.species) } ?: setSpecies("")
            char?.let { setGender(it.gender) } ?: setGender("")
            char?.let { setOriginName(it.origin.name) } ?: setOriginName("")
            char?.let { setLocationName(it.location.name) } ?: setLocationName("")
            char?.let { setCreated(it.created) } ?: setCreated("")
            char?.let { loadImage(it.image) }
            setHomeButton()
        }
    }

    private fun loadData() {
        try {
            runBlocking {
                char = repo.getChar(charUrl)
            }
        } catch (e: Throwable) {
            viewState.setAlert(e.message.toString())
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}