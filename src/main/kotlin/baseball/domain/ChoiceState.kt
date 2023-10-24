package baseball.domain

enum class ChoiceState(val stateCode: Int) {
    RESTART(1),
    EXIT(2),
    START(3)
}