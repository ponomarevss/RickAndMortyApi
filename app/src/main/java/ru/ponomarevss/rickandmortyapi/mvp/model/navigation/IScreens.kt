package ru.ponomarevss.rickandmortyapi.mvp.model.navigation

import com.github.terrakok.cicerone.Screen
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.Char

interface IScreens {
    fun chars(): Screen
    fun char(char: Char): Screen
}