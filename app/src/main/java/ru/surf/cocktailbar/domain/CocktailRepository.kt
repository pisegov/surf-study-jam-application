package ru.surf.cocktailbar.domain

import ru.surf.cocktailbar.domain.model.CocktailWithIngredients
import ru.surf.cocktailbar.ui.cocktails_list_fragment.CocktailCard

interface CocktailRepository {
    suspend fun getCocktailCards(): List<CocktailCard>
    suspend fun getCocktailWithIngredients(id: Int): CocktailWithIngredients

    suspend fun addCocktail(cocktail: CocktailWithIngredients)
}