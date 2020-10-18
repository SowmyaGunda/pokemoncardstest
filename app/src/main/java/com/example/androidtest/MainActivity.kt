package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidtest.viewmodel.PokemanCardsViewModel
import com.example.androidtest.viewmodel.PokemonCardData

class MainActivity : AppCompatActivity() {
    private val observable = Observer<PokemonCardData>{
        println("sowmya"+ (it.cards?.size ?: 0))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getViewModel().cardData.observe(this, observable)
        getCards()
    }
    private fun getViewModel() : PokemanCardsViewModel{
        return ViewModelProvider(this).get(PokemanCardsViewModel::class.java)
    }
    private fun getCards(){
        getViewModel().getCards()
    }
}