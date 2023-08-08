package ru.surf.cocktailbar.ui.cocktails_list_fragment

import androidx.recyclerview.widget.DiffUtil

object CocktailsDiffCallback : DiffUtil.ItemCallback<CocktailCard>() {

    override fun areItemsTheSame(oldItem: CocktailCard, newItem: CocktailCard): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: CocktailCard, newItem: CocktailCard): Boolean {
        return oldItem.title == newItem.title
    }

    override fun getChangePayload(oldItem: CocktailCard, newItem: CocktailCard): Any? {
        return if (oldItem.title != newItem.title) true else null
    }
}