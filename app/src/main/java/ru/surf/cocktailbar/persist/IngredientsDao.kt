package ru.surf.cocktailbar.persist

import androidx.room.Dao
import androidx.room.Insert
import ru.surf.cocktailbar.persist.model.Ingredient

@Dao
interface IngredientsDao {
    @Insert
    fun insertAll(ingredients: List<Ingredient>)
}