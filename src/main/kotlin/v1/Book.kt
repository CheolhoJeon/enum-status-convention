package v1

import BookStatus
import StateMachine

class Book(
    val id: Long,
    val title: String,
) {

    var status: BookStatus = BookStatus.READY_TO_RENT

    // Some properties...

    fun rent() {
        /* Business Logic */

        status to BookStatus.RENTED
    }

    fun `return`() {
        /* Business Logic */

        status to BookStatus.READY_TO_RENT
    }

    fun lose() {
        /* Business Logic */

        status to BookStatus.LOST
    }

    private infix fun StateMachine.to(newStatus: BookStatus) {
        check(this canBe newStatus) { "현재 상태($status)에서 새로운 상태($newStatus)가 될 수 없습니다" }
        status = newStatus
    }

}