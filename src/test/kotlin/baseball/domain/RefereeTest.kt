package baseball.domain

import baseball.domain.model.Computer
import baseball.domain.model.Player
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RefereeTest {
    @ParameterizedTest
    @MethodSource("provideStrikeData")
    fun `스트라이크 기능 테스트`(player: Player, computer: Computer, expectedStrikeCount: Int) {
        val actualStrikeCount = Referee(player, computer).strike()

        assertThat(actualStrikeCount).isEqualTo(expectedStrikeCount)
    }

    @ParameterizedTest
    @MethodSource("provideBallData")
    fun `볼`(player: Player, computer: Computer, expectedBallCount: Int) {
        val actualBallCount = Referee(player, computer).ball()

        assertThat(actualBallCount).isEqualTo(expectedBallCount)
    }

    @ParameterizedTest
    @MethodSource("provideNothingData")
    fun `낫싱`(player: Player, computer: Computer, expectedIsNothing: Boolean) {
        val actualIsNothing = Referee(player, computer).nothing()

        assertThat(actualIsNothing).isEqualTo(expectedIsNothing)
    }

    companion object {
        @JvmStatic
        fun provideStrikeData(): List<Arguments> = listOf(
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 2, 3)), 3), // 3strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 2, 4)), 2), // 2strike, 0ball
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 3, 2)), 1), // 1strike, 2ball
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(3, 2, 4)), 1), // 1strike, 1ball
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(3, 1, 2)), 0), // 1strike, 0ball
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(4, 5, 6)), 0), // nothing
        )

        @JvmStatic
        fun provideBallData(): List<Arguments> = listOf(
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(3, 1, 2)), 3), // 3ball
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(2, 1, 3)), 2), // 2ball, 1strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(2, 1, 4)), 2), // 2ball, 0strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 3, 4)), 1), // 1ball, 1strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(3, 4, 5)), 1), // 1ball, 0strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 2, 3)), 0), // 0ball, 3strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 2, 4)), 0), // 0ball, 2strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 4, 5)), 0), // 0ball, 1strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(4, 5, 6)), 0), // nothing
        )

        @JvmStatic
        fun provideNothingData(): List<Arguments> = listOf(
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(3, 1, 2)), false), // 3ball
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(2, 1, 3)), false), // 2ball, 1strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(2, 1, 4)), false), // 2ball, 0strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 3, 4)), false), // 1ball, 1strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(3, 4, 5)), false), // 1ball, 0strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 2, 3)), false), // 0ball, 3strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 2, 4)), false), // 0ball, 2strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(1, 4, 5)), false), // 0ball, 1strike
            Arguments.of(Player(listOf(1, 2, 3)), Computer(listOf(4, 5, 6)), true), // nothing
        )
    }
}