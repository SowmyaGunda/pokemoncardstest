package com.example.androidtest

import com.example.androidtest.api.retrofit.PokemonModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PokemonModule::class])
interface PokemonTestComponent: PokemonDIComponent {
    fun inject(pokemonApiUnitTests: PokemonApiUnitTests)
}