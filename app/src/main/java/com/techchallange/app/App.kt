package com.techchallange.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        loadKoin()
    }

    private fun loadKoin(){
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}