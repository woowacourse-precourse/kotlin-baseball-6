package validator.gamecontrolvalidator

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameControlValidatorTest {
    private lateinit var gameControlValidator: GameControlValidator

    @BeforeEach
    fun setUp() {
        gameControlValidator = GameControlValidatorImpl
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["1", "2"]
    )
    fun `숫자가 1이나 2일때 성공인지`(oneOrTwo: String) {
        val result = gameControlValidator.isOneOrTwo(oneOrTwo)
        assertTrue(result)
    }
}