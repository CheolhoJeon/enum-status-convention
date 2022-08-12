package v4

import BookStatus

class Book(
    val id: Long,
    val title: String,
) : Statusable<BookStatus>(BookStatus.READY_TO_RENT) {

    // Some properties...

    fun rent() {
        /* Business Logic */

        status = BookStatus.RENTED
    }

    fun `return`() {
        /* Business Logic */

        status = BookStatus.READY_TO_RENT
    }

    fun lose() {
        /* Business Logic */

        status = BookStatus.LOST
    }

}