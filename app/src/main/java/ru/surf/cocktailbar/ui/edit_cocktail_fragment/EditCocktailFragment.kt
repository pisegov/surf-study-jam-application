package ru.surf.cocktailbar.ui.edit_cocktail_fragment

import androidx.fragment.app.Fragment
import ru.surf.cocktailbar.R
import ru.surf.cocktailbar.databinding.FragmentEditCocktailBinding
import ru.surf.cocktailbar.ui.base.viewBinding

class EditCocktailFragment : Fragment(R.layout.fragment_edit_cocktail) {
    val binding by viewBinding { FragmentEditCocktailBinding.bind(it) }
}