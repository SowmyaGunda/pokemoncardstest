package com.example.androidtest.api.restApiClient

import com.example.androidtest.api.model.CardResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApiService {
    @GET("cards")
    fun getCards(): Call<CardResponse>
}