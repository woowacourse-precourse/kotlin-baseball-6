package baseball

import baseball.model.validation.DuplicateNumberValidation
import baseball.model.validation.InvalidLengthValidation
import baseball.model.validation.NumberValidation
import baseball.model.validation.OutOfRangeNumberValidation
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidationTest {
    @Test
    fun `입력 값이 숫자인지`() {
        assertThrows<IllegalArgumentException> {
            NumberValidation().check("하이")
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