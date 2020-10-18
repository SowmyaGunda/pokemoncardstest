package com.example.androidtest.api.model


internal object ModelMapper {

    fun to(model: CardModel): PokemonCard {
        return PokemonCard(
            model.id,
            model.name,
            model.nationalPokedexNumber,
            model.imageUrl,
            model.imageUrlHiRes,
            model.types?.map { Type.find(it) },
            SuperType.find(model.supertype),
            SubType.find(model.subtype),
            model.evolvesFrom,
            model.hp?.toIntOrNull(),
            model.retreatCost?.map { Type.find(it) },
            model.convertedRetreatCost,
            model.number,
            model.artist,
            model.rarity,
            model.series,
            model.set,
            model.setCode,
            model.text,
            model.attacks?.map { to(it) },
            model.weaknesses?.map { to(it) },
            model.resistances?.map { to(it) },
            model.ability?.let { to(it) },
            model.ancientTrait?.let { to(it) }
        )
    }

    private fun to(model: AbilityModel): Ability {
        return Ability(model.name, model.text, model.type)
    }

    private fun to(model: AttackModel): Attack {
        return Attack(
            model.cost?.map { Type.find(it) },
            model.name,
            model.text,
            model.damage,
            model.convertedEnergyCost
        )
    }

    private fun to(model: EffectModel): Effect {
        return Effect(Type.find(model.type), model.value)
    }

}
