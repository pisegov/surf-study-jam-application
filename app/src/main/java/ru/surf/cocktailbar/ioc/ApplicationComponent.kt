package ru.surf.cocktailbar.ioc

import androidx.lifecycle.ViewModelProvider
import dagger.Component
import dagger.Module
import javax.inject.Scope

@Component(modules = [ApplicationModule::class, ViewModelModule::class])
@ApplicationScope
interface ApplicationComponent {

    @Component.Factory
    interface Factory {

        fun create(

        ): ApplicationComponent
    }

    val viewModelFactory: ViewModelProvider.Factory
}

@Scope
annotation class ApplicationScope

@Module
interface ApplicationModule
