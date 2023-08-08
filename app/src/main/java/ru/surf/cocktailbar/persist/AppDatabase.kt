package ru.surf.cocktailbar.persist

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.surf.cocktailbar.persist.model.CocktailEntity
import ru.surf.cocktailbar.persist.model.Ingredient

@Database(entities = [CocktailEntity::class, Ingredient::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cocktailsDao(): CocktailsDao
    abstract fun ingredientsDao(): IngredientsDao
}