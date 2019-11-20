package io.github.proudust.stickymemo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TestApplication)
            androidLogger()
            modules(inMemoryDataBaseModules)
            modules(applicationModules)
        }
    }

}
