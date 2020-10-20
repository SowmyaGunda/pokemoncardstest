package com.example.androidtest.viewmodel

import androidx.lifecycle.*
import com.example.androidtest.DaggerPokemonDIComponent
import com.example.androidtest.api.model.CardResponse
import com.example.androidtest.api.model.PokemonCard
import com.example.androidtest.api.retrofit.PokemonApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

data class PokemonCardData(val cards: List<PokemonCard>?, val throwable: Throwable?)

class PokemonCardsViewModel (private val pokemonApi: PokemonApiService) : ViewModel() {
    val cardData = MutableLiveData<PokemonCardData>()

    init {
        DaggerPokemonDIComponent.create().inject(this)
    }

    fun getCards() {
        viewModelScope.launch(Dispatchers.IO) {
            val cards = pokemonApi.getCards()
            cards.enqueue(object : Callback<CardResponse> {
                override fun onFailure(call: Call<CardResponse>, t: Throwable) {
                    cardData.postValue(PokemonCardData(null, t))
                }

                override fun onResponse(call: Call<CardResponse>, response: Response<CardResponse>) {
                    if (response.isSuccessful) {
                        response.body()?.cards?.map {
                            com.example.androidtest.api.model.ModelMapper.to(
                                    it
                            )
                        }?.let { cardData.postValue(PokemonCardData(it, null)) }
                    } else {
                        cardData.postValue(PokemonCardData(null,HttpException(response)))
                    }
                }

            })
        }

    }

}