package validator.gamecontrolvalidator

import org.junit.jupiter.api.BeforeEach

class GameControlValidatorTest {
    private lateinit var gameControlValidator: GameControlValidator

    @BeforeEach
    fun setUp() {
        gameControlValidator = GameControlValidatorImpl
    }
}