package ru.surf.cocktailbar.domain.model

data class CocktailWithIngredients(
    val id: Int,
    val title: String,
    val ingredients: List<String>,
    val description: String?,
    val recipe: String?,
)
