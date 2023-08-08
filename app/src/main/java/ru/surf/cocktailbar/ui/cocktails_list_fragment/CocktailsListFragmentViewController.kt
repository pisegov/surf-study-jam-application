package ru.surf.cocktailbar.ui.cocktails_list_fragment

import android.app.Activity
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import ru.surf.cocktailbar.R
import ru.surf.cocktailbar.databinding.FragmentCocktailsListBinding
import javax.inject.Inject

class CocktailsListFragmentViewController @Inject constructor(
    private val activity: Activity,
    private val binding: FragmentCocktailsListBinding,
    private val cardsAdapter: CocktailsCardsAdapter,
    private val viewModel: CocktailsListViewModel,
    private val lifecycleOwner: LifecycleOwner,
) {
    fun setupViews() {
        with(binding) {
            tvMyCocktails.text = "My cocktails"

            setupRecycler()

            fabAddCocktail.setOnClickListener {
                findNavController(binding.root)
                    .navigate(R.id.action_cocktailsListFragment_to_editCocktailFragment)
            }
        }
        viewModel.loadCocktailsCards()
        lifecycleOwner.lifecycleScope.launch {
            viewModel.cardsListFlow.collect {
                checkListEmptinessAndSetupViews(it)
//                cardsAdapter.submitList(list)
            }
        }
    }


    private fun setupRecycler() {
        with(binding) {
            cocktailsRecycler.apply {
                adapter = cardsAdapter
                layoutManager =
                    GridLayoutManager(
                        activity,
                        2,
                        RecyclerView.VERTICAL,
                        false
                    )
                addItemDecoration(
                    CocktailCardsOffsetDecoration(
                        rightOffset = 8,
                        leftOffset = 8,
                        topOffset = 8,
                        bottomOffset = 8
                    )
                )
            }
        }
    }

    private fun checkListEmptinessAndSetupViews(list: List<CocktailCard>) {
        cardsAdapter.submitList(list)

        with(binding) {
            if (list.isEmpty()) {
                cocktailsRecycler.visibility = View.GONE
                emptyListImage.visibility = View.VISIBLE

                changeTextViewConstraints(binding.emptyListImage.id, ConstraintSet.BOTTOM)
            } else {
                cocktailsRecycler.visibility = View.VISIBLE
                emptyListImage.visibility = View.GONE

                changeTextViewConstraints(binding.root.id, constraintTo = ConstraintSet.TOP)
            }
        }
    }

    private fun changeTextViewConstraints(viewOnTop: Int, constraintTo: Int) {
        val constraintLayout: ConstraintLayout = binding.root
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(
            binding.tvMyCocktails.id,
            ConstraintSet.TOP,
            viewOnTop,
            constraintTo,
            0
        )
        constraintSet.applyTo(constraintLayout)
    }
}
