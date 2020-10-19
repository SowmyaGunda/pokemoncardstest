package com.example.androidtest.viewmodel

import androidx.lifecycle.*
import com.example.androidtest.PokemonApplication
import com.example.androidtest.PokemonDIComponent
import com.example.androidtest.api.model.PokemonCard
import com.example.androidtest.api.retrofit.Pokemanapi
import com.example.androidtest.api.retrofit.PokemonResponseListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PokemonCardData(val cards: List<PokemonCard>?, val throwable: Throwable?)

class PokemanCardsViewModel : ViewModel() {
    val cardData = MutableLiveData<PokemonCardData>()

    @Inject
    lateinit var pokemonApi: Pokemanapi

    init {
        val pokemnDIComponent: PokemonDIComponent = PokemonApplication.pokemonDIComponent
        pokemnDIComponent.inject(this)
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