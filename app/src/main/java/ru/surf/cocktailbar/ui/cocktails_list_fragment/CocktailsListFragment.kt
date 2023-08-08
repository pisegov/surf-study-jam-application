package ru.surf.cocktailbar.ui.cocktails_list_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.surf.cocktailbar.App
import ru.surf.cocktailbar.R
import ru.surf.cocktailbar.databinding.FragmentCocktailsListBinding
import ru.surf.cocktailbar.ui.base.viewBinding
import ru.surf.cocktailbar.ui.cocktails_list_fragment.ioc.CocktailsListFragmentComponent
import ru.surf.cocktailbar.ui.cocktails_list_fragment.ioc.CocktailsListFragmentViewComponent
import ru.surf.cocktailbar.ui.cocktails_list_fragment.ioc.DaggerCocktailsListFragmentComponent
import ru.surf.cocktailbar.ui.cocktails_list_fragment.ioc.DaggerCocktailsListFragmentViewComponent


class CocktailsListFragment : Fragment(R.layout.fragment_cocktails_list) {
    private val binding by viewBinding { FragmentCocktailsListBinding.bind(it) }

    private val applicationComponent
        get() = App.get(requireContext()).applicationComponent
    private lateinit var fragmentComponent: CocktailsListFragmentComponent
    private var fragmentViewComponent: CocktailsListFragmentViewComponent? = null
    private val viewModel: CocktailsListViewModel by viewModels { applicationComponent.viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentComponent = DaggerCocktailsListFragmentComponent.factory()
            .create(applicationComponent = applicationComponent, fragment = this, viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentViewComponent = DaggerCocktailsListFragmentViewComponent.factory()
            .create(fragmentComponent, binding, viewLifecycleOwner)
            .apply {
                cocktailsListFragmentViewController.setupViews()
            }
    }
}

