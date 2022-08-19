package v5

interface StateMachine {

    val canBe: (newStatus: StateMachine) -> Boolean

    infix fun `is`(status: StateMachine) = this == status

    companion object {
        const val NOT_THING = false
        const val ANY_THING = true
    }

}