package ru.surf.cocktailbar.ui.cocktails_list_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.surf.cocktailbar.databinding.ItemCocktailBinding
import ru.surf.cocktailbar.ui.cocktails_list_fragment.ioc.CocktailsListFragmentScope
import javax.inject.Inject


@CocktailsListFragmentScope
class CocktailsCardsAdapter @Inject constructor(private val viewModel: CocktailsListViewModel) :
    ListAdapter<CocktailCard, CocktailCardViewHolder>(CocktailsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailCardViewHolder {
        val view = ItemCocktailBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CocktailCardViewHolder(view, viewModel)
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