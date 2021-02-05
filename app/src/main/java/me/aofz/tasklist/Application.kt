package me.aofz.tasklist

import android.app.Application
import me.aofz.tasklist.di.AppComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(AppComponent)
        }
    }

}