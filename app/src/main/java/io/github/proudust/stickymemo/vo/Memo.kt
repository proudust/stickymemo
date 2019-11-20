package io.github.proudust.stickymemo.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memos")
data class Memo(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "memo_id")
    val memoId: Int,

    @ColumnInfo(name = "content", defaultValue = "")
    val content: String,

    @ColumnInfo(name = "rank", defaultValue = "1")
    val rank: Int,

    @ColumnInfo(name = "created_at")
    val createdAt: String,

    @ColumnInfo(name = "update_at")
    val updateAt: String

)
