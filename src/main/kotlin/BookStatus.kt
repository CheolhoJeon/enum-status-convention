enum class BookStatus : StateMachine {

    // 대여 대기
    READY_TO_RENT {
        override fun canBe(newStatus: StateMachine) = newStatus in listOf(RENTED, LOST)
    },

    // 대여중
    RENTED {
        override fun canBe(newStatus: StateMachine) = newStatus in listOf(READY_TO_RENT, LOST)
    },

    // 분실
    LOST {
        override fun canBe(newStatus: StateMachine) = false
    },
    ;

}