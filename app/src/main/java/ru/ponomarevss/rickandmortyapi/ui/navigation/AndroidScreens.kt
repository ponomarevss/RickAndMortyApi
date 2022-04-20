package ru.ponomarevss.rickandmortyapi.ui.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.ponomarevss.rickandmortyapi.mvp.model.entity.Char
import ru.ponomarevss.rickandmortyapi.mvp.model.navigation.IScreens
import ru.ponomarevss.rickandmortyapi.ui.fragment.CharFragment
import ru.ponomarevss.rickandmortyapi.ui.fragment.CharsFragment

class AndroidScreens : IScreens {

    override fun chars(): Screen = FragmentScreen { CharsFragment.newInstance() }

    override fun char(charUrl: String): Screen = FragmentScreen { CharFragment.newInstance(charUrl) }
}