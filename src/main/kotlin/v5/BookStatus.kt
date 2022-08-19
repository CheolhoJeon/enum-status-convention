package v5

enum class BookStatus(override val canBe: (newStatus: StateMachine) -> Boolean) : StateMachine {

    // 대여 대기
    READY_TO_RENT({ newStatus -> newStatus in listOf(RENTED, LOST) }),

    // 대여중
    RENTED({ newStatus -> newStatus in listOf(READY_TO_RENT, LOST) }),

    // 분실
    LOST({ StateMachine.NOT_THING }),
    ;

}