package ru.surf.cocktailbar.ui.cocktails_list_fragment.ioc

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.surf.cocktailbar.databinding.FragmentCocktailsListBinding
import ru.surf.cocktailbar.ui.cocktails_list_fragment.CocktailsListFragmentViewController
import javax.inject.Scope

@Component(
    modules = [CocktailsListFragmentViewModule::class],
    dependencies = [CocktailsListFragmentComponent::class]
)
@CocktailsListFragmentViewScope
interface CocktailsListFragmentViewComponent {
    @Component.Factory
    interface Factory {
        fun create(
            cocktailsListFragmentComponent: CocktailsListFragmentComponent,
            @BindsInstance viewBinding: FragmentCocktailsListBinding,
            @BindsInstance lifecycleOwner: LifecycleOwner,
        ): CocktailsListFragmentViewComponent
    }

    val cocktailsListFragmentViewController: CocktailsListFragmentViewController
}

@Scope
annotation class CocktailsListFragmentViewScope

@Module
interface CocktailsListFragmentViewModule {
    companion object {
        @Provides
        fun activity(fragment: Fragment): Activity {
            return fragment.requireActivity()
        }
    }
}
