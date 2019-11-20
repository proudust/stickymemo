package io.github.proudust.helloworld

import android.os.Build
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = HelloWorldApplication::class, sdk = [Build.VERSION_CODES.P])
class ApplicationModulesTest : AutoCloseKoinTest() {

    @Test
    fun `check koin modules definitions`() {
        getKoin().checkModules()
    }

}
