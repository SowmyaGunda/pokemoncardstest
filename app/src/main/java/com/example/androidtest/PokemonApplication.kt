package com.example.androidtest

import android.app.Application
import android.content.Context
import com.example.androidtest.api.retrofit.PokemonModule

class PokemonApplication : Application() {
    companion object {
        var ctx: Context? = null
        lateinit var pokemonDIComponent: PokemonDIComponent
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
       pokemonDIComponent = initDaggerComponent()

    }


    private fun initDaggerComponent(): PokemonDIComponent {
        pokemonDIComponent = DaggerPokemonDIComponent
            .builder()
            .applcation(this)
        return pokemonDIComponent

    }
}