package io.github.proudust.helloworld

import io.github.proudust.helloworld.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModules = module {
    viewModel { MainViewModel() }
}
