package baseball.model.validator

import baseball.assertEqualsThrowsMessage
import baseball.model.validator.AnswerValidation.ErrorType.*

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.IllegalArgumentException

class AnswerValidationTest {

    @ParameterizedTest
    @ValueSource(strings = ["12", "1234", ""])
    fun assertValidLength(input: String) {
        assertEqualsThrowsMessage<IllegalArgumentException>(InvalidLength.message) {
            AnswerValidation(input).assertValidLength()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["+12", "-12", "  "])
    fun assertNumeric(input: String) {
        assertEqualsThrowsMessage<IllegalArgumentException>(NotNumeric.message) {
            AnswerValidation(input).assertNumeric()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["111", "101", "233333333"])
    fun assertNotDuplicated(input: String) {
        assertEqualsThrowsMessage<IllegalArgumentException>(Duplicated.message) {
            AnswerValidation(input).assertNotDuplicated()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0"])
    fun assertInOfRange(input: String) {
        assertEqualsThrowsMessage<IllegalArgumentException>(OutOfRange.message) {
            AnswerValidation(input).assertInOfRange()
        }
    }
}