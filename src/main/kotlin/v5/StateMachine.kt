package v5

interface StateMachine {

    val canBe: (newStatus: StateMachine) -> Boolean

    infix fun `is`(status: StateMachine) = this == status

}