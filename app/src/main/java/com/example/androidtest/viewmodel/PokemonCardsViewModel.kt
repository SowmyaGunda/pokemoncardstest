package com.example.androidtest.viewmodel

import androidx.lifecycle.*
import com.example.androidtest.PokemonApplication
import com.example.androidtest.PokemonDIComponent
import com.example.androidtest.api.model.PokemonCard
import com.example.androidtest.api.restApiClient.PokemonApi
import com.example.androidtest.api.restApiClient.PokemonResponseListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PokemonCardData(val cards: List<PokemonCard>?, val throwable: Throwable?)

class PokemanCardsViewModel : ViewModel() {
    val cardData = MutableLiveData<PokemonCardData>()

    @Inject
    lateinit var pokemonApi: PokemonApi

    init {
        val pokemonDIComponent: PokemonDIComponent = PokemonApplication.pokemonDIComponent
        pokemonDIComponent.inject(this)
    }

      fun getCards() {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonApi.getAllCards(object : PokemonResponseListener {
                override fun onSuccess(allCards: List<PokemonCard>) {
                    cardData.postValue(PokemonCardData(allCards, null))
                }

                override fun onFailure(exception: Throwable) {
                    cardData.postValue(PokemonCardData(null, exception))
                }
            })
        }

    }

}