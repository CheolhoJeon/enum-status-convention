package v4

import StateMachine

/**
 * 인터페이스의 경우 백킹 필드를 사용할 수 없으므로, 추상클래스로 선언해야한다
 * 세터의 동작을 변경 시키는 또 다른 방법으로 Property Delegation을 사용할 수도 있다
 */
abstract class StatusChangeable<T : StateMachine>(status: T) {

    var status: T = status
        set(value) {
            check(field canBe value) { "현재 상태($status)에서 새로운 상태($value)가 될 수 없습니다" }
            field = value
        }

}