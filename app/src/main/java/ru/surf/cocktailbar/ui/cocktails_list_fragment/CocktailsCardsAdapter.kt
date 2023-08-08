package ru.surf.cocktailbar.ui.cocktails_list_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.surf.cocktailbar.databinding.ItemCocktailBinding


class CocktailsCardsAdapter() :
    ListAdapter<CocktailCard, CocktailCardViewHolder>(CocktailsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailCardViewHolder {
        val view = ItemCocktailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CocktailCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailCardViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: CocktailCardViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }
}