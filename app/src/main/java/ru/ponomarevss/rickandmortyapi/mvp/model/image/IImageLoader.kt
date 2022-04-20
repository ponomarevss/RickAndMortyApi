package ru.ponomarevss.rickandmortyapi.mvp.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}