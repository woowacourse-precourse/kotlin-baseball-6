package validator.baseballnumbervalidator

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseballNumberValidatorTest {
    private lateinit var baseballNumberValidator: BaseballNumberValidator

    @BeforeEach
    fun setUp() {
        baseballNumberValidator = BaseballNumberValidatorImpl
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["123", "145", "789", "235"]
    )
    fun `세 자리 수 일때 성공인지`(baseballRandomNumber: String) {
        val result = baseballNumberValidator.isThreeLetters(baseballRandomNumber)
        assertTrue(result)
    }
}