package ru.ponomarevss.rickandmortyapi.mvp.view

import androidx.appcompat.app.AlertDialog
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CharView: MvpView {
    fun setTitle(text: String)
    fun setStatus(text: String)
    fun setSpecies(text: String)
    fun setGender(text: String)
    fun setOriginName(text: String)
    fun setLocationName(text: String)
    fun setCreated(text: String)
    fun loadImage(url: String)
    fun setHomeButton()
    fun setAlert(text: String)
}