package com.example.androidtest

import com.example.androidtest.api.retrofit.Pokemanapi
import com.example.androidtest.api.retrofit.PokemonModule
import com.example.androidtest.viewmodel.PokemanCardsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PokemonModule::class])
interface PokemonDIComponent {
    fun inject(pokemanapi: Pokemanapi)
    fun inject(pokemanCardsViewModel: PokemanCardsViewModel)
}