package com.example.androidtest

import android.app.Application
import android.content.Context

class PokemonApplication : Application() {
    companion object {
        var ctx: Context? = null
        //lateinit var pokemonDIComponent: PokemonDIComponent
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
        //pokemonDIComponent = initDaggerComponent()

    }

    /*private fun initDaggerComponent(): PokemonDIComponent {
         return DaggerPokemonDIComponent.create()
     }*/
}