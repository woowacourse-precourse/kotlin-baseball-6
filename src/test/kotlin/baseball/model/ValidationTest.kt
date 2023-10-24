package baseball.model

import baseball.assertEqualsThrowsMessage
import baseball.model.validation.*
import baseball.model.validation.InputError.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {
    @ParameterizedTest
    @ValueSource(strings = ["-21", "마라탕", "+12"])
    fun `입력 값이 기호를 포함하지 않는 숫자인지`(input: String) {
        assertEqualsThrowsMessage<IllegalArgumentException>(NotPositiveNumber.message) {
            PositiveNumberValidation().check(input)
        }
    }

    @Test
    fun `입력 값에 중복 값이 존재하는지`() {
        assertEqualsThrowsMessage<IllegalArgumentException>(DuplicateNumber.message) {
            DuplicateNumberValidation().check("111")
        }
    }

    @Test
    fun `입력 값이 세 자리인지`() {
        assertEqualsThrowsMessage<IllegalArgumentException>(InvalidLength.message) {
            InvalidLengthValidation().check("1234")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["+12", "-12", "0", "0123", "가나다"])
    fun `입력 값의 각각의 범위가 1~9까지인지`(input: String) {
        assertEqualsThrowsMessage<IllegalArgumentException>(OutOfRangeNumber.message) {
            OutOfRangeNumberValidation().check(input)
        }
    }
}