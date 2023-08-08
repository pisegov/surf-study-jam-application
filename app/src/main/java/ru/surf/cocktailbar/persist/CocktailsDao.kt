package ru.surf.cocktailbar.persist

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import ru.surf.cocktailbar.persist.model.CocktailEntity
import ru.surf.cocktailbar.persist.model.CocktailWithIngredientEntities

@Dao
interface CocktailsDao {
    @Query("SELECT * FROM cocktails")
    fun getAll(): List<CocktailEntity>

    @Query("SELECT * FROM cocktails WHERE cocktail_id LIKE :id")
    fun findById(id: Int): CocktailWithIngredientEntities

    @Upsert
    fun insert(cocktail: CocktailEntity): Long

    @Query("DELETE FROM cocktails WHERE cocktail_id LIKE :id")
    fun deleteById(id: Int)
}