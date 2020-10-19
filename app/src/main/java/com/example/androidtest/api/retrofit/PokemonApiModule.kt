package com.example.androidtest.api.retrofit

import androidx.lifecycle.ViewModel
import com.example.androidtest.viewmodel.PokemanCardsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Module
abstract class PokemonApiModule {
    @Binds
    @Singleton
    abstract fun bindPokemonApi(pokemanapi: Pokemanapi):Pokemanapi


}