interface StateMachine {

    infix fun canBe(newStatus: StateMachine): Boolean

    infix fun `is`(status: StateMachine) = this == status

}