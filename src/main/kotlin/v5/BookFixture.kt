package v5

class BookFixture {
    companion object {
        fun create(
            id: Long = 0L,
            title: String = "홍길동전",
            status: BookStatus = BookStatus.READY_TO_RENT,
        ): Book {
            return Book(
                id = id,
                title = title,
            ).apply {
                this.status = status
            }
        }
    }
}