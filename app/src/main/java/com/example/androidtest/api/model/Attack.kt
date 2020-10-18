package com.example.androidtest.api.model

data class Attack(
    val cost: List<Type>?,
    val name: String,
    val text: String?,
    val damage: String?,
    val convertedEnergyCost: Int
)
