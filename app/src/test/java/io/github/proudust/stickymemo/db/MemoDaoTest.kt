package io.github.proudust.stickymemo.db

import android.os.Build
import com.google.common.truth.Truth.assertThat
import io.github.proudust.stickymemo.TestApplication
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class, sdk = [Build.VERSION_CODES.P])
class MemoDaoTest : AutoCloseKoinTest() {

    private val db: StickyMemoDatabase by inject()
    private val memo = db.memo()

    @Before
    fun setup() {
        (1..5).forEach { memo.insert("test data $it") }
    }

    @Test
    fun `Sort memos from new to old by default`() {
        assertThat(memo.getList().map { it.memoId }).containsExactly(5, 4, 3, 2, 1).inOrder()
    }

    @Test
    fun `Sort memos in reverse order`() = memo.run {
        assertThat(getList().map { it.memoId }).containsExactly(5, 4, 3, 2, 1).inOrder()
        assertThat(getList().map { it.rank }).containsExactly(5, 4, 3, 2, 1).inOrder()

        updateOrder(fromRank = 5, toRank = 1)
        assertThat(getList().map { it.memoId }).containsExactly(4, 3, 2, 1, 5).inOrder()
        assertThat(getList().map { it.rank }).containsExactly(5, 4, 3, 2, 1).inOrder()

        updateOrder(fromRank = 5, toRank = 2)
        assertThat(getList().map { it.memoId }).containsExactly(3, 2, 1, 4, 5).inOrder()
        assertThat(getList().map { it.rank }).containsExactly(5, 4, 3, 2, 1).inOrder()

        updateOrder(fromRank = 3, toRank = 5)
        assertThat(getList().map { it.memoId }).containsExactly(1, 3, 2, 4, 5).inOrder()
        assertThat(getList().map { it.rank }).containsExactly(5, 4, 3, 2, 1).inOrder()

        updateOrder(fromRank = 3, toRank = 4)
        assertThat(getList().map { it.memoId }).containsExactly(1, 2, 3, 4, 5).inOrder()
        assertThat(getList().map { it.rank }).containsExactly(5, 4, 3, 2, 1).inOrder()
    }

    @Test
    fun `Update memo content`() = memo.run {
        val before = getList()[3]
        updateContent(2, "changed data")
        val after = getList()[3]

        assertThat(getList().map { it.memoId }).containsExactly(5, 4, 3, 2, 1).inOrder()

        assertThat(after.memoId).isEqualTo(before.memoId)
        assertThat(after.content).isEqualTo("changed data")
        assertThat(after.createdAt).isEqualTo(before.createdAt)
        assertThat(after.updateAt).isNotEqualTo(before.updateAt)
    }

    @Test
    fun `Delete memo`() = memo.run {
        delete(2)

        assertThat(getList().map { it.memoId }).containsExactly(5, 4, 3, 1).inOrder()
    }

}
