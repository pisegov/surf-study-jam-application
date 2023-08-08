package ru.surf.cocktailbar.ui.edit_cocktail_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.surf.cocktailbar.domain.CocktailRepository
import ru.surf.cocktailbar.domain.model.CocktailWithIngredients
import javax.inject.Inject

class EditCocktailViewModel @Inject constructor(private val repository: CocktailRepository) :
    ViewModel() {

    fun addCocktail(cocktail: CocktailWithIngredients) {
        viewModelScope.launch {
            repository.addCocktail(cocktail)
        }
    }
}
