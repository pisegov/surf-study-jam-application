package ru.surf.cocktailbar.ioc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import ru.surf.cocktailbar.ui.cocktails_list_fragment.CocktailsListViewModel
import ru.surf.cocktailbar.ui.edit_cocktail_fragment.EditCocktailViewModel
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

@ApplicationScope
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.get() as T
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CocktailsListViewModel::class)
    fun cocktailsListViewModel(viewModel: CocktailsListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditCocktailViewModel::class)
    fun editCocktailViewModel(viewModel: EditCocktailViewModel): ViewModel
}