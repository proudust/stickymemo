package io.github.proudust.stickymemo

import androidx.room.Room
import io.github.proudust.stickymemo.db.StickyMemoDatabase
import io.github.proudust.stickymemo.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataBaseModules = module {
    single { Room.databaseBuilder(get(), StickyMemoDatabase::class.java, "sticky_memo").build() }
}

val applicationModules = module {
    viewModel { MainViewModel() }
}
