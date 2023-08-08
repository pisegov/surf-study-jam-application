package ru.surf.cocktailbar

import android.app.Application
import android.content.Context
import androidx.room.Room
import ru.surf.cocktailbar.ioc.ApplicationComponent
import ru.surf.cocktailbar.ioc.ApplicationScope
import ru.surf.cocktailbar.ioc.DaggerApplicationComponent
import ru.surf.cocktailbar.persist.AppDatabase

@ApplicationScope
class App : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "cocktails-database"
        ).build()

        DaggerApplicationComponent.factory().create(db)
    }


    companion object {
        fun get(context: Context): App = context.applicationContext as App
    }
}