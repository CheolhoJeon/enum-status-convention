package v6

interface StateMachine {

    val nextStatuses: () -> List<StateMachine>

    infix fun `is`(status: StateMachine) = this == status

    companion object {
        val NOT_THING = listOf<StateMachine>()
    }

}