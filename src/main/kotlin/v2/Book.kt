package v2

import BookStatus

class Book(
    val id: Long,
    val title: String,
): Statusable<BookStatus>(BookStatus.READY_TO_RENT) {

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

}