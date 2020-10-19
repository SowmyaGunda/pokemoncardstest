package com.example.androidtest

import com.example.androidtest.api.restApiClient.PokemonApi
import com.example.androidtest.api.restApiClient.PokemonModule
import com.example.androidtest.viewmodel.PokemanCardsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PokemonModule::class])
interface PokemonDIComponent {
    fun inject(pokemonApi: PokemonApi)
    fun inject(pokemonCardsViewModel: PokemanCardsViewModel)
}