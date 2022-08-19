package v6

import v6.StateMachine.Companion.NOT_THING

/**
 * newStatus의 타입이 왜 List<StateMachine>이 아닌 () -> List<StateMachine>인가?
 * 선언 시점에 선언되지 않은 상태를 파라미터로 넘길 수 없기 때문
 */
enum class BookStatus(override val nextStatus: () -> List<StateMachine>) : StateMachine {

    // 대여 대기
    READY_TO_RENT({ listOf(RENTED, LOST) }),

    // 대여중
    RENTED({ listOf(READY_TO_RENT, LOST) }),

    // 분실
    LOST({ NOT_THING }),
    ;

}