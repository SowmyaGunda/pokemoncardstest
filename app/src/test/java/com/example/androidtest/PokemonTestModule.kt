package com.example.androidtest

import com.example.androidtest.api.retrofit.Pokemanapi
import com.example.androidtest.api.retrofit.PokemonModule
import io.mockk.mockk
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonTestModule : PokemonModule() {
    override fun provideGSON(): GsonConverterFactory = mockk()
    override fun provideOKHttpClient(): OkHttpClient = mockk()
    override fun providePokemonApi(): Pokemanapi = mockk()
    override fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit = mockk()
}