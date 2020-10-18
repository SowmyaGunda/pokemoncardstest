package com.example.androidtest.api.model


import kotlinx.serialization.Serializable

@Serializable
class CardResponse(val cards: List<CardModel>)

@Serializable
class CardModel(
    val id: String,
    val name: String,
    val nationalPokedexNumber: Int? = null,
    val imageUrl: String,
    val imageUrlHiRes: String,
    val types: List<String>? = null,
    val supertype: String,
    val subtype: String? = null,
    val evolvesFrom: String? = null,
    val hp: String? = null,
    val retreatCost: List<String>? = null,
    val convertedRetreatCost: Int? = null,
    val number: String,
    val artist: String? = null,
    val rarity: String? = null,
    val series: String,
    val set: String,
    val setCode: String,
    val text: List<String>? = null,
    val attacks: List<AttackModel>? = null,
    val weaknesses: List<EffectModel>? = null,
    val resistances: List<EffectModel>? = null,
    val ability: AbilityModel? = null,
    val ancientTrait: AbilityModel? = null
)

@Serializable
class AbilityModel(
    val name: String,
    val text: String,
    val type: String? = null
)

@Serializable
class AttackModel(
    val cost: List<String>? = null,
    val name: String,
    val text: String? = null,
    val damage: String? = null,
    val convertedEnergyCost: Int
)

@Serializable
class EffectModel(
    val type: String,
    val value: String
)

