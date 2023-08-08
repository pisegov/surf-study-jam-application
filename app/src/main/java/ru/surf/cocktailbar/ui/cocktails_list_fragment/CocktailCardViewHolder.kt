package ru.surf.cocktailbar.ui.cocktails_list_fragment

import androidx.recyclerview.widget.RecyclerView
import ru.surf.cocktailbar.databinding.ItemCocktailBinding

class CocktailCardViewHolder(
    private val binding: ItemCocktailBinding,
) : RecyclerView.ViewHolder(binding.root) {

    init {
        //TODO set onclick listener on card
    }

    fun onBind(
        cocktailItem: CocktailCard
    ) {
        binding.cocktailTitle.text = cocktailItem.title
    }
}