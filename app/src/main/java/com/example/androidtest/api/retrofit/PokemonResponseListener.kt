package com.example.androidtest.api.retrofit

import com.example.androidtest.api.model.PokemonCard

interface PokemonResponseListener {
    fun onSuccess(allCards:List<PokemonCard>)
    fun onFailure(exception:Throwable)
}