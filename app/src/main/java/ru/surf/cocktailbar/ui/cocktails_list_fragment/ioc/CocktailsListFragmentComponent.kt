package ru.surf.cocktailbar.ui.cocktails_list_fragment.ioc

import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.surf.cocktailbar.ioc.ApplicationComponent
import ru.surf.cocktailbar.ui.cocktails_list_fragment.CocktailsCardsAdapter
import ru.surf.cocktailbar.ui.cocktails_list_fragment.CocktailsListViewModel
import javax.inject.Scope

@Component(
    modules = [CocktailsListFragmentModule::class],
    dependencies = [ApplicationComponent::class]
)
@CocktailsListFragmentScope
interface CocktailsListFragmentComponent {
    @Component.Factory
    interface Factory {
        fun create(
            applicationComponent: ApplicationComponent,
            @BindsInstance fragment: Fragment,
            @BindsInstance viewModel: CocktailsListViewModel
        ): CocktailsListFragmentComponent
    }

    fun fragment(): Fragment
    fun viewModel(): CocktailsListViewModel
    fun adapter(): CocktailsCardsAdapter
}

@Scope
annotation class CocktailsListFragmentScope

@Module
interface CocktailsListFragmentModule {


}