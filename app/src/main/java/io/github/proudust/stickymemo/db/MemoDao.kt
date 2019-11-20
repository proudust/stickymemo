package io.github.proudust.stickymemo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import io.github.proudust.stickymemo.vo.Memo

@Dao
interface MemoDao {

    @Query("SELECT * FROM memos ORDER BY rank DESC")
    fun getLiveData(): LiveData<List<Memo>>

    @Query("SELECT * FROM memos ORDER BY rank DESC")
    fun getList(): List<Memo>

    @Query(
        """
INSERT INTO memos(content, rank, created_at, update_at)
SELECT :content as content,
       IFNULL(MAX(rank) + 1, 1) as rank,
       $DATETIME_NOW as created_at,
       $DATETIME_NOW as update_at
FROM   memos
"""
    )
    fun insert(content: String)

    @Query(
        """
UPDATE memos
SET    content = :content,
       update_at = $DATETIME_NOW
WHERE  memo_id = :memoId
"""
    )
    fun updateContent(memoId: Int, content: String)

    @Query(
        """
UPDATE memos
SET    rank = CASE WHEN :fromRank < :toRank THEN
                   CASE WHEN rank = :fromRank THEN :toRank
                        WHEN :fromRank < rank AND rank <= :toRank THEN rank - 1
                        ELSE rank END
                   WHEN :toRank < :fromRank THEN
                   CASE WHEN rank = :fromRank THEN :toRank
                        WHEN :toRank <= rank AND rank < :fromRank THEN rank + 1
                        ELSE rank END
                   ELSE rank END,
       update_at = $DATETIME_NOW
WHERE  CASE WHEN :fromRank < :toRank THEN rank BETWEEN :fromRank AND :toRank
            WHEN :toRank < :fromRank THEN rank BETWEEN :toRank AND :fromRank
            ELSE 0 END
"""
    )
    fun updateOrder(fromRank: Int, toRank: Int)

    @Query("DELETE FROM memos WHERE memo_id = :memoId")
    fun delete(memoId: Int)

}
