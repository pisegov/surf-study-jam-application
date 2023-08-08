package ru.surf.cocktailbar.persist

import ru.surf.cocktailbar.domain.model.CocktailWithIngredients
import ru.surf.cocktailbar.persist.model.CocktailEntity
import ru.surf.cocktailbar.persist.model.CocktailWithIngredientEntities
import ru.surf.cocktailbar.ui.cocktails_list_fragment.CocktailCard

fun CocktailEntity.toCocktailCard(): CocktailCard {
    return CocktailCard(
        title = this.title
    )
}

fun CocktailWithIngredientEntities.toCocktailWithIngredients(): CocktailWithIngredients {
    return CocktailWithIngredients(
        id = this.cocktailInfo.id,
        title = this.cocktailInfo.title,
        ingredients = this.ingredients.map { it.value },
        description = this.cocktailInfo.description,
        recipe = this.cocktailInfo.recipe
    )
}

fun CocktailWithIngredients.toCocktailEntity(): CocktailEntity {
    return CocktailEntity(id, title, description, recipe)
}