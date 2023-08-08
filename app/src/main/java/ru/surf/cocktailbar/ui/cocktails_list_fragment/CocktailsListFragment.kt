package ru.surf.cocktailbar.ui.cocktails_list_fragment

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.surf.cocktailbar.R
import ru.surf.cocktailbar.databinding.FragmentCocktailsListBinding
import ru.surf.cocktailbar.ui.base.viewBinding


class CocktailsListFragment : Fragment(R.layout.fragment_cocktails_list) {
    private val binding by viewBinding { FragmentCocktailsListBinding.bind(it) }
    private val list: List<CocktailCard> = listOf(
        CocktailCard("First"),
        CocktailCard("Second"),
        CocktailCard("Ogo vau"),
        CocktailCard("Another one"),
        CocktailCard("Fifth"),
    )

//    private val list: List<CocktailCard> = emptyList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            tvMyCocktails.text = "My cocktails"

            val adapter = CocktailsCardsAdapter()
            cocktailsRecycler.apply {
                this.adapter = adapter
                layoutManager =
                    GridLayoutManager(
                        requireContext(),
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

            adapter.submitList(list)

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