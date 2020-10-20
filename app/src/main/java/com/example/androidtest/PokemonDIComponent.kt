package com.example.androidtest

import com.example.androidtest.api.restApiClient.PokemonModule
import com.example.androidtest.viewmodel.PokemonCardsViewModel
import com.example.androidtest.viewmodel.ViewModelFactory
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [PokemonModule::class])
interface PokemonDIComponent {
    fun inject(pokemonCardsViewModel: PokemonCardsViewModel)
    fun inject(viewModelFactory: ViewModelFactory)
}
