package com.example.androidtest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidtest.DaggerPokemonDIComponent
import com.example.androidtest.api.retrofit.PokemonApiService
import retrofit2.Retrofit
import javax.inject.Inject

class ViewModelFactory : ViewModelProvider.Factory {
    @Inject
    lateinit var retrofit: Retrofit
    lateinit var apiService: PokemonApiService

    @ExperimentalStdlibApi
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        DaggerPokemonDIComponent.create().inject(this)
        apiService = retrofit.create(PokemonApiService::class.java)

        if (modelClass.isAssignableFrom(PokemonCardsViewModel::class.java)) {
            return PokemonCardsViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}