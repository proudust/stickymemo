package io.github.proudust.helloworld

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HelloWorldApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@HelloWorldApplication)
            androidLogger()
            modules(applicationModules)
        }
    }

}
