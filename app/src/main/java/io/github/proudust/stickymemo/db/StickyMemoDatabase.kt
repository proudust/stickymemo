package io.github.proudust.stickymemo.db

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.proudust.stickymemo.vo.Memo

/**
 * SQLite で ISO 8601 に準拠した日時(ミリ秒付き)を取得するための文
 */
const val DATETIME_NOW = "strftime('%Y-%m-%dT%H:%M:%f', 'now')"

@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class StickyMemoDatabase : RoomDatabase() {

    abstract fun memo(): MemoDao

}
