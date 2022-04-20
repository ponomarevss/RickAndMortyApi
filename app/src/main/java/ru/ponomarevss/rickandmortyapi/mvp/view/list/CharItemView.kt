package ru.ponomarevss.rickandmortyapi.mvp.view.list

interface CharItemView: IItemView {
    fun setName(text: String)
    fun setSpecies(text: String)
    fun setGender(text: String)
    fun loadImage(url: String)
}