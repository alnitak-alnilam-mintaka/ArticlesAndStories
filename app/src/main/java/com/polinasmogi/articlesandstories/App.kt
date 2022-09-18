package com.polinasmogi.articlesandstories

import android.app.Application
import com.polinasmogi.articlesandstories.di.apiModule
import com.polinasmogi.articlesandstories.di.databaseModule
import com.polinasmogi.articlesandstories.di.repositoryModule
import com.polinasmogi.articlesandstories.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                viewModelModule,
                repositoryModule,
                apiModule,
                databaseModule
            )
        }
    }

}