package ru.ponomarevss.rickandmortyapi.mvp.presenter

import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.runBlocking
import moxy.MvpPresenter
import ru.ponomarevss.rickandmortyapi.BuildConfig.TITLE
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.Char
import ru.ponomarevss.rickandmortyapi.mvp.model.navigation.IScreens
import ru.ponomarevss.rickandmortyapi.mvp.model.repo.ICharsRepo
import ru.ponomarevss.rickandmortyapi.mvp.presenter.list.ICharsListPresenter
import ru.ponomarevss.rickandmortyapi.mvp.view.CharsView
import ru.ponomarevss.rickandmortyapi.mvp.view.list.CharItemView
import javax.inject.Inject

class CharsPresenter : MvpPresenter<CharsView>() {
    companion object {
//        private const val TITLE = "Characters"
    }

    @Inject lateinit var router: Router
    @Inject lateinit var screens: IScreens
    @Inject lateinit var repo: ICharsRepo

    inner class CharsListPresenter : ICharsListPresenter {
        val chars = mutableListOf<Char>()
        override var itemClickListener: ((CharItemView) -> Unit)? = null

        override fun bindView(view: CharItemView) {
            val char = chars[view.pos]
            with(view) {
                with(char) {
                    setName(name)
                    setSpecies(species)
                    setGender(gender)
                    loadImage(image)
                }
            }
        }

        override fun getCount(): Int = chars.size
    }

    val charsListPresenter = CharsListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
        viewState.init()
        viewState.setTitle(TITLE)
        viewState.setHomeButton()

        charsListPresenter.itemClickListener = {
            val charUrl = charsListPresenter.chars[it.pos].url
            router.navigateTo(screens.char(charUrl))
        }
    }

    private fun loadData() {
        charsListPresenter.chars.clear()
        try {
            runBlocking {
                charsListPresenter.chars.addAll(repo.getCharsRespond().results)
            }
        } catch (e: Throwable) {
            viewState.setAlert(e.message.toString())
        }
        viewState.update()
    }
    
    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}