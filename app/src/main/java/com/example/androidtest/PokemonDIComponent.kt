package com.example.androidtest

import android.app.Application
import com.example.androidtest.api.retrofit.Pokemanapi
import com.example.androidtest.api.retrofit.PokemonApiModule
import com.example.androidtest.api.retrofit.PokemonModule
import com.example.androidtest.viewmodel.PokemanCardsViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PokemonModule::class,PokemonApiModule::class])
interface PokemonDIComponent {
    fun inject(pokemanapi: Pokemanapi)
    fun inject(pokemanCardsViewModel: PokemanCardsViewModel)
}