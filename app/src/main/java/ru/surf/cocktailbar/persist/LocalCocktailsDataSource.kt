package ru.surf.cocktailbar.persist

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.surf.cocktailbar.domain.model.CocktailWithIngredients
import ru.surf.cocktailbar.persist.model.Ingredient
import ru.surf.cocktailbar.ui.cocktails_list_fragment.CocktailCard
import javax.inject.Inject

class LocalCocktailsDataSource @Inject constructor(private val db: AppDatabase) {

    suspend fun getCocktails(): List<CocktailCard> = withContext(Dispatchers.IO) {

        return@withContext db.cocktailsDao().getAll().map { it.toCocktailCard() }
    }

    suspend fun getCocktailById(id: Int): CocktailWithIngredients = withContext(Dispatchers.IO) {
        return@withContext db.cocktailsDao().findById(id).toCocktailWithIngredients()
    }

    suspend fun insertCocktail(cocktail: CocktailWithIngredients) =
        withContext(Dispatchers.IO) {

            val key = db.cocktailsDao().insert(cocktail.toCocktailEntity()).toInt()
            db.ingredientsDao().insertAll(
                cocktail.ingredients.map { Ingredient(cocktailId = key, value = it) })
        }
}