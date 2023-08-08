package ru.surf.cocktailbar.ui.edit_cocktail_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.surf.cocktailbar.App
import ru.surf.cocktailbar.R
import ru.surf.cocktailbar.databinding.FragmentEditCocktailBinding
import ru.surf.cocktailbar.ioc.ApplicationComponent
import ru.surf.cocktailbar.ui.base.viewBinding
import ru.surf.cocktailbar.ui.edit_cocktail_fragment.ioc.DaggerEditCocktailFragmentComponent
import ru.surf.cocktailbar.ui.edit_cocktail_fragment.ioc.DaggerEditCocktailFragmentViewComponent
import ru.surf.cocktailbar.ui.edit_cocktail_fragment.ioc.EditCocktailFragmentComponent
import ru.surf.cocktailbar.ui.edit_cocktail_fragment.ioc.EditCocktailFragmentViewComponent

class EditCocktailFragment : Fragment(R.layout.fragment_edit_cocktail) {
    private val binding by viewBinding { FragmentEditCocktailBinding.bind(it) }

    private val applicationComponent: ApplicationComponent
        get() = App.get(requireContext()).applicationComponent

    private lateinit var fragmentComponent: EditCocktailFragmentComponent
    private var fragmentViewComponent: EditCocktailFragmentViewComponent? = null
    private val viewModel: EditCocktailViewModel by viewModels { applicationComponent.viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentComponent = DaggerEditCocktailFragmentComponent.factory().create(
            applicationComponent,
            fragment = this,
            viewModel
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentViewComponent = DaggerEditCocktailFragmentViewComponent.factory().create(
            fragmentComponent,
            binding,
            viewLifecycleOwner
        ).apply {
            editCocktailFragmentViewController.setupViews()
        }

    }
}