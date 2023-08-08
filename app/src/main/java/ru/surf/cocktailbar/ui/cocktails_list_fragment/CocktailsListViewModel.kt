package ru.surf.cocktailbar.ui.cocktails_list_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.surf.cocktailbar.domain.CocktailRepository
import javax.inject.Inject

class CocktailsListViewModel @Inject constructor(private val repository: CocktailRepository) :
    ViewModel() {

    private val _cardsListFlow: MutableStateFlow<List<CocktailCard>> = MutableStateFlow(emptyList())
    val cardsListFlow: StateFlow<List<CocktailCard>> get() = _cardsListFlow
    fun loadCocktailsCards() {
        viewModelScope.launch {
            _cardsListFlow.update { repository.getCocktailCards() }
        }
    }
}
