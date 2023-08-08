package ru.surf.cocktailbar.ui.edit_cocktail_fragment.ioc

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.surf.cocktailbar.databinding.FragmentEditCocktailBinding
import ru.surf.cocktailbar.ui.edit_cocktail_fragment.EditCocktailFragmentViewController
import javax.inject.Scope

@Component(
    modules = [EditCocktailFragmentViewModule::class],
    dependencies = [EditCocktailFragmentComponent::class]
)
@EditCocktailFragmentViewScope
interface EditCocktailFragmentViewComponent {
    @Component.Factory
    interface Factory {
        fun create(
            editCocktailFragmentComponent: EditCocktailFragmentComponent,
            @BindsInstance viewBinding: FragmentEditCocktailBinding,
            @BindsInstance lifecycleOwner: LifecycleOwner,
        ): EditCocktailFragmentViewComponent
    }

    val editCocktailFragmentViewController: EditCocktailFragmentViewController
}

@Scope
annotation class EditCocktailFragmentViewScope

@Module
interface EditCocktailFragmentViewModule {
    companion object {
        @Provides
        fun activity(fragment: Fragment): Activity {
            return fragment.requireActivity()
        }
    }
}
