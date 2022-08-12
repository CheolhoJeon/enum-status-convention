package v2

import StateMachine

abstract class Statusable<T : StateMachine>(var status: T) {

    protected infix fun StateMachine.to(newStatus: T) {
        check(this canBe newStatus) { "현재 상태($status)에서 새로운 상태($newStatus)가 될 수 없습니다" }
        status = newStatus
    }

}