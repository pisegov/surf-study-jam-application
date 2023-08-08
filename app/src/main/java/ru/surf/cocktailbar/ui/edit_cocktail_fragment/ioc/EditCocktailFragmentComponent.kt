package ru.surf.cocktailbar.ui.edit_cocktail_fragment.ioc

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.surf.cocktailbar.ioc.ApplicationComponent
import ru.surf.cocktailbar.ui.edit_cocktail_fragment.EditCocktailViewModel
import javax.inject.Scope

@Component(
    modules = [EditCocktailFragmentModule::class],
    dependencies = [ApplicationComponent::class]
)
@EditCocktailFragmentScope
interface EditCocktailFragmentComponent {
    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance fragment: Fragment,
            @BindsInstance viewModel: EditCocktailViewModel
        ): EditCocktailFragmentComponent
    }

    fun fragment(): Fragment

    fun viewModel(): EditCocktailViewModel
}

@Scope
annotation class EditCocktailFragmentScope

@Module
interface EditCocktailFragmentModule