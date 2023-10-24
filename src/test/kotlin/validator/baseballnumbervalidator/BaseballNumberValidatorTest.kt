package validator.baseballnumbervalidator

import org.junit.jupiter.api.Assertions
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

    @ParameterizedTest
    @ValueSource(
        strings = ["123", "145", "789", "235"]
    )
    fun `숫자가 전부 다른 숫자 일때 성공인지`(input: String) {
        val result = baseballNumberValidator.allThreeLettersDifferent(input)
        assertTrue(result)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["123", "145", "789", "235"]
    )
    fun `전부 숫자 일때 성공인지`(input: String) {
        val result = baseballNumberValidator.isItANumber(input)
        assertTrue(result)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["1234", "1", "12", "12345", ""]
    )
    fun `세 자리 수가 아닐 때 오류를 던지는지`(input: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { baseballNumberValidator.isThreeLetters(input) }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["반가워", "안녕1", "2T3", "12a"]
    )
    fun `숫자가 아닌 것이 포함돼 있을 때 오류를 던지는지`(input: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) { baseballNumberValidator.isItANumber(input) }
    }
}