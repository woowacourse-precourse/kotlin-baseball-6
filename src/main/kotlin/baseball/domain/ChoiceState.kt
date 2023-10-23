package baseball.domain

enum class ChoiceState(val stateCode: Int) {
    Restart(1),
    Exit(2),
    Start(3)
}