package v6

interface StateMachine {

    val nextStatus: () -> List<StateMachine>

    infix fun `is`(status: StateMachine) = this == status

    companion object {
        val NOT_THING = listOf<StateMachine>()
        val ANY_THING = listOf<StateMachine>() // 이거 방법 없나...?
    }

}