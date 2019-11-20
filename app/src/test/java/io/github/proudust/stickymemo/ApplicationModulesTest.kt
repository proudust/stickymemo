package io.github.proudust.stickymemo

import android.os.Build
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = StickyMemoApplication::class, sdk = [Build.VERSION_CODES.P])
class ApplicationModulesTest : AutoCloseKoinTest() {

    @Test
    fun `check koin modules definitions`() {
        getKoin().checkModules()
    }

}
