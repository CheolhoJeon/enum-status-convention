package v5

import v5.BookStatus.*

class Book(
    val id: Long,
    val title: String,
) : StatusChangeable<BookStatus> {

    override var status: BookStatus = READY_TO_RENT

    // Some properties...

    fun rent() {
        /* Business Logic */

        status to RENTED
    }

    fun `return`() {
        /* Business Logic */

        status to READY_TO_RENT
    }

    fun lose() {
        /* Business Logic */

        status to LOST
    }

}