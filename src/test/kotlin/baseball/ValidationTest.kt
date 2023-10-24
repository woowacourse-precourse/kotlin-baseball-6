package baseball

import baseball.model.validation.DuplicateNumberValidation
import baseball.model.validation.InvalidLengthValidation
import baseball.model.validation.PositiveNumberValidation
import baseball.model.validation.OutOfRangeNumberValidation
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {
    @ParameterizedTest
    @ValueSource(strings = ["-21", "마라탕", "0"])
    fun `입력 값이 양수인지`(input: String) {
        assertThrows<IllegalArgumentException> {
            PositiveNumberValidation().check(input)
        }
    }

    @Test
    fun `입력 값에 중복 값이 존재하는지`() {
        assertThrows<IllegalArgumentException> {
            DuplicateNumberValidation().check("111")
        }
    }

    @Test
    fun `입력 값이 세 자리인지`() {
        assertThrows<IllegalArgumentException> {
            InvalidLengthValidation().check("1234")
        }
    }

    @Test
    fun `입력 값의 범위가 1~9까지인지`() {
        val validation = OutOfRangeNumberValidation()
        assertThrows<IllegalArgumentException> {
            validation.check("012")
        }
        assertDoesNotThrow {
            validation.check("123")
        }
    }
}