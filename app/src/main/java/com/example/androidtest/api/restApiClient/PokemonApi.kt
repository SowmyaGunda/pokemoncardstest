package com.example.androidtest.api.restApiClient

import com.example.androidtest.PokemonApplication
import com.example.androidtest.PokemonDIComponent
import com.example.androidtest.api.model.CardResponse
import retrofit2.*
import javax.inject.Inject

class PokemonApi {
    @Inject
    lateinit var pokemonApiService: PokemonApiService

    init {
        val pokemnDIComponent: PokemonDIComponent = PokemonApplication.pokemonDIComponent
        pokemnDIComponent.inject(this)
    }

      fun getAllCards(pokemonResponseListener: PokemonResponseListener) {
         val cards = pokemonApiService.getCards()
        cards.enqueue(object : Callback<CardResponse> {
            override fun onFailure(call: Call<CardResponse>, t: Throwable) {
                pokemonResponseListener.onFailure(t)
            }

            override fun onResponse(call: Call<CardResponse>, response: Response<CardResponse>) {
                if (response.isSuccessful) {
                    response.body()?.cards?.map {
                        com.example.androidtest.api.model.ModelMapper.to(
                                it
                        )
                    }?.let { pokemonResponseListener.onSuccess(it) }
                } else {
                    pokemonResponseListener.onFailure(HttpException(response))
                }
            }

        })
    }

}