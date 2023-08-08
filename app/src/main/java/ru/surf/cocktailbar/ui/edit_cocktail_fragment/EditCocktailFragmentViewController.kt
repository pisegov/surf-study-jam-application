package ru.surf.cocktailbar.ui.edit_cocktail_fragment

import android.app.Activity
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import ru.surf.cocktailbar.databinding.FragmentEditCocktailBinding
import ru.surf.cocktailbar.domain.model.CocktailWithIngredients
import javax.inject.Inject

class EditCocktailFragmentViewController @Inject constructor(
    private val activity: Activity,
    private val viewModel: EditCocktailViewModel,
    private val viewBinding: FragmentEditCocktailBinding,
    private val lifecycleOwner: LifecycleOwner
) {

    fun setupViews() {
        with(viewBinding) {
            saveButton.setOnClickListener {
                val title = etCocktailName.text.toString()
                val description = etCocktailDescription.text.toString()
                val recipe = etCocktailRecipe.text.toString()

                if (title == "") {
                    Toast.makeText(activity, "Nope", Toast.LENGTH_SHORT).show()
                } else {
                    val cocktail = CocktailWithIngredients(
                        title = title,
                        description = description,
                        recipe = recipe,
                        ingredients = emptyList()
                    )

                    viewModel.addCocktail(cocktail)
                    Navigation.findNavController(viewBinding.root)
                        .navigateUp()
                }

            }
            cancelButton.setOnClickListener {
                Navigation.findNavController(viewBinding.root)
                    .navigateUp()
            }
        }
    }
}
