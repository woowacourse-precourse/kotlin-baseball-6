package baseball.domain

import baseball.domain.model.Computer
import baseball.domain.model.JudgeResult
import baseball.domain.model.Player

class Referee(
    private val player: Player,
    private val computer: Computer,
) {
    fun judge() = JudgeResult(strike(), ball(), nothing())
    // strike, ball, nothing private으로 바꾸고, judge로 test하기
    fun strike(): Int =
        computer.number.indices.count { computer.number[it] == player.number[it] }

    fun ball(): Int =
        computer.number.intersect(player.number.toSet()).size - strike()

    fun nothing(): Boolean =
        computer.number.intersect(player.number.toSet()).isEmpty()
}