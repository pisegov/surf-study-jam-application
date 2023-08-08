package ru.surf.cocktailbar

import android.app.Application
import android.content.Context
import ru.surf.cocktailbar.ioc.ApplicationComponent
import ru.surf.cocktailbar.ioc.ApplicationScope
import ru.surf.cocktailbar.ioc.DaggerApplicationComponent

@ApplicationScope
class App : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }

    companion object {
        fun get(context: Context): App = context.applicationContext as App
    }
}