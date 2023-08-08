package ru.surf.cocktailbar.persist

import ru.surf.cocktailbar.domain.CocktailRepository
import ru.surf.cocktailbar.domain.model.CocktailWithIngredients
import ru.surf.cocktailbar.ioc.ApplicationScope
import ru.surf.cocktailbar.ui.cocktails_list_fragment.CocktailCard
import javax.inject.Inject

@ApplicationScope
class CocktailRepositoryImpl @Inject constructor(private val localDataSource: LocalCocktailsDataSource) :
    CocktailRepository {
    override suspend fun getCocktailCards(): List<CocktailCard> {
        return localDataSource.getCocktails()
    }

    override suspend fun getCocktailWithIngredients(id: Int): CocktailWithIngredients {
        return localDataSource.getCocktailById(id)
    }

    override suspend fun addCocktail(cocktail: CocktailWithIngredients) {
        localDataSource.insertCocktail(cocktail)
    }
}