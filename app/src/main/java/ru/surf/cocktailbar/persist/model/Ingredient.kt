package ru.surf.cocktailbar.persist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CocktailEntity::class,
            parentColumns = ["cocktail_id"],
            childColumns = ["cocktail_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Ingredient(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,

    val value: String
)
