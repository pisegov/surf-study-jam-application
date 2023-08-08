package ru.surf.cocktailbar.ui.cocktails_list_fragment

import android.app.Activity
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.surf.cocktailbar.databinding.FragmentCocktailsListBinding
import javax.inject.Inject

class CocktailsListFragmentViewController @Inject constructor(
    private val activity: Activity,
    private val binding: FragmentCocktailsListBinding,
    private val cardsAdapter: CocktailsCardsAdapter,
    private val viewModel: CocktailsListViewModel
) {
    private val list: List<CocktailCard> = listOf(
        CocktailCard("First"),
        CocktailCard("Second"),
        CocktailCard("Ogo vau"),
        CocktailCard("Another one"),
        CocktailCard("Fifth"),
    )

    //    private val list: List<CocktailCard> = emptyList()

    fun setupViews() {
        with(binding) {
            tvMyCocktails.text = "My cocktails"

            setupRecycler()
            checkListEmptinessAndSetupViews()
        }
    }


    private fun setupRecycler() {
        with(binding)
        {
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

    private fun checkListEmptinessAndSetupViews() {
        with(binding) {
            if (list.isEmpty()) {
                cocktailsRecycler.visibility = View.GONE
                emptyListImage.visibility = View.VISIBLE

                changeTextViewConstraints(binding.emptyListImage.id, ConstraintSet.BOTTOM)

            } else {
                cocktailsRecycler.visibility = View.VISIBLE
                emptyListImage.visibility = View.GONE

                changeTextViewConstraints(binding.root.id, constraintTo = ConstraintSet.TOP)

                cardsAdapter.submitList(list)
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
