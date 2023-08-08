package ru.surf.cocktailbar.persist.model

import androidx.room.Embedded
import androidx.room.Relation

data class CocktailWithIngredientEntities(
    @Embedded
    val cocktailInfo: CocktailEntity,

    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "cocktail_id",
    )
    val ingredients: List<Ingredient>
)

