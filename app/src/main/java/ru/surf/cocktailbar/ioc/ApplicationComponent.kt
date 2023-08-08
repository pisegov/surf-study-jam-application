package ru.surf.cocktailbar.ioc

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import ru.surf.cocktailbar.domain.CocktailRepository
import ru.surf.cocktailbar.persist.AppDatabase
import ru.surf.cocktailbar.persist.CocktailRepositoryImpl
import ru.surf.cocktailbar.persist.LocalCocktailsDataSource
import javax.inject.Scope

@Component(modules = [ApplicationModule::class, ViewModelModule::class])
@ApplicationScope
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance database: AppDatabase
        ): ApplicationComponent
    }

    val viewModelFactory: ViewModelProvider.Factory
    val localDataSource: LocalCocktailsDataSource
}

@Scope
annotation class ApplicationScope

@Module
interface ApplicationModule {
    @Binds
    fun repository(repositoryImpl: CocktailRepositoryImpl): CocktailRepository
}
