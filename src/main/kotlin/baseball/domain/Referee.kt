package baseball.domain

import baseball.domain.model.Computer
import baseball.domain.model.Player

class Referee(
    private val player: Player,
    private val computer: Computer,
) {
    fun strike(): Int =
        computer.number.indices.count { computer.number[it] == player.number[it] }

    fun ball(): Int =
        computer.number.intersect(player.number.toSet()).size - strike()

    fun nothing(): Boolean =
        computer.number.intersect(player.number.toSet()).isEmpty()
}