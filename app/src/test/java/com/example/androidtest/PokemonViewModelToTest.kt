package com.example.androidtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidtest.api.model.CardModel
import com.example.androidtest.api.model.CardResponse
import com.example.androidtest.api.retrofit.PokemonApiService
import com.example.androidtest.viewmodel.PokemonCardsViewModel
import okhttp3.Request
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class PokemonViewModelToTest {
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: PokemonApiService

    lateinit var pokemonCardsViewModel: PokemonCardsViewModel

    private  var loading: Boolean = false

    @Before
    fun setUp() {
        pokemonCardsViewModel = PokemonCardsViewModel(apiService)
    }

    @Test
    fun verifyApiInvoking(){

        pokemonCardsViewModel.getCards()
        verify(apiService).getCards()
    }

}