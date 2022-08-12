package v3

import StateMachine

interface Statusable<T : StateMachine> {

    var status: T

    /**
     * StateMachine 인터페이스에 대한 확장함수이기 때문에, Statusable을 구현하는 클래스 외부에서 접근할 수 없다
     * 즉, protected 제한자의 효과를 가진다
     */
    infix fun StateMachine.to(newStatus: T) {
        check(this canBe newStatus) { "현재 상태($status)에서 새로운 상태($newStatus)가 될 수 없습니다" }
        status = newStatus
    }

}