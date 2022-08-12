enum class BookStatus : StateMachine {

    // 대여 대기
    READY_TO_RENT {
        override fun canBe(newStatus: StateMachine): Boolean = newStatus.let { it `is` RENTED || it `is` LOST }
    },
    // 대여중
    RENTED {
        override fun canBe(newStatus: StateMachine): Boolean = newStatus.let { it `is` READY_TO_RENT || it `is` LOST }
    },
    // 분실
    LOST {
        override fun canBe(newStatus: StateMachine): Boolean = false
    },
    ;

}