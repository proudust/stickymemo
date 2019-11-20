package io.github.proudust.stickymemo

import io.github.proudust.stickymemo.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val applicationModules = module {
    viewModel { MainViewModel() }
}
