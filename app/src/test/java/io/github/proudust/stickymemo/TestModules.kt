package io.github.proudust.stickymemo

import androidx.room.Room
import io.github.proudust.stickymemo.db.StickyMemoDatabase
import org.koin.dsl.module

val inMemoryDataBaseModules = module {
    single {
        Room.inMemoryDatabaseBuilder(get(), StickyMemoDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }
}
