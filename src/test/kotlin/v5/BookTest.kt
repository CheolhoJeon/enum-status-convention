package v5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import v5.BookStatus.LOST
import v5.BookStatus.READY_TO_RENT
import v5.BookStatus.RENTED

class BookTest {

    /* Testing for rent() */
    @Test
    fun `책을 대여한다`() {
        // given
        val book = BookFixture.create(status = READY_TO_RENT)

        // when
        book.rent()

        // then
        assertThat(book.status).isEqualTo(RENTED)
    }

    @Test
    fun `대여 상태에서 또 다시 대여를 시도하면 예외를 던진다`() {
        // given
        val book = BookFixture.create(status = RENTED)

        // when & then
        val exception = assertThrows<IllegalStateException> { book.rent() }
        assertThat(exception.message).isEqualTo("현재 상태(RENTED)에서 새로운 상태(RENTED)가 될 수 없습니다")
    }

    @Test
    fun `분실 상태에서 대여를 시도하면 예외를 던진다`() {
        // given
        val book = BookFixture.create(status = LOST)

        // when & then
        val exception = assertThrows<IllegalStateException> { book.rent() }
        assertThat(exception.message).isEqualTo("현재 상태(LOST)에서 새로운 상태(RENTED)가 될 수 없습니다")
    }

    /* Testing for return() */
    @Test
    fun `책을 반납한다`() {
        // given
        val book = BookFixture.create(status = RENTED)

        // when
        book.`return`()

        // then
        assertThat(book.status).isEqualTo(READY_TO_RENT)
    }

    @Test
    fun `대여 대기 상태에서 반납을 시도하면 예외를 던진다`() {
        // given
        val book = BookFixture.create(status = READY_TO_RENT)

        // when & then
        val exception = assertThrows<IllegalStateException> { book.`return`() }
        assertThat(exception.message).isEqualTo("현재 상태(READY_TO_RENT)에서 새로운 상태(READY_TO_RENT)가 될 수 없습니다")
    }

    @Test
    fun `분실 상태에서 반납을 시도하면 예외를 던진다`() {
        // given
        val book = BookFixture.create(status = LOST)

        // when & then
        val exception = assertThrows<IllegalStateException> { book.`return`() }
        assertThat(exception.message).isEqualTo("현재 상태(LOST)에서 새로운 상태(READY_TO_RENT)가 될 수 없습니다")
    }

    /* Testing for lose() */
    @Test
    fun `대여대기 상태의 책을 분실처리한다`() {
        // given
        val book = BookFixture.create(status = READY_TO_RENT)

        // when
        book.lose()

        // then
        assertThat(book.status).isEqualTo(LOST)
    }

    @Test
    fun `대여중 상태의 책을 분실처리한다`() {
        // given
        val book = BookFixture.create(status = RENTED)

        // when
        book.lose()

        // then
        assertThat(book.status).isEqualTo(LOST)
    }

}