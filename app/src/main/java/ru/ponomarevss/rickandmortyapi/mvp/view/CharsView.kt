package ru.ponomarevss.rickandmortyapi.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CharsView: MvpView {
    fun init()
    fun update()
    fun setTitle(text: String)
    fun setHomeButton()
}