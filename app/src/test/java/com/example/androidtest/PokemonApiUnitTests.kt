package com.example.androidtest

import com.example.androidtest.api.retrofit.Pokemanapi
import com.example.androidtest.api.retrofit.PokemanapiImpl
import com.example.androidtest.api.retrofit.PokemonApiService
import com.example.androidtest.api.retrofit.PokemonResponseListener
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import javax.inject.Inject

class PokemonApiUnitTests {

    @Inject
     lateinit var pokemonApiService:PokemonApiService

    lateinit var pokemanapi: Pokemanapi

    val pokemonResponseListener : PokemonResponseListener = mockk()

    @Before
    fun setUp() {
        val component = DaggerPokemonTestComponent.builder()
            .pokemonModule(PokemonTestModule())
            .build()
        component.inject(this)

    }
    @Test
    fun checkingServiceMethodInvoiking(){
        pokemanapi.getAllCards(pokemonResponseListener)
        verify(){
            pokemonApiService.getCards()
        }

    }
}