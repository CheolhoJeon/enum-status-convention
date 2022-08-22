package v6

class Book(
    val id: Long,
    val title: String,
) : StatusChangeable<BookStatus> {

    override var status: BookStatus = BookStatus.READY_TO_RENT

    // Some properties...

    fun rent() {
        /* Business Logic */

        status becomes BookStatus.RENTED
    }

    fun `return`() {
        /* Business Logic */

        status becomes BookStatus.READY_TO_RENT
    }

    fun lose() {
        /* Business Logic */

        status becomes BookStatus.LOST
    }

}