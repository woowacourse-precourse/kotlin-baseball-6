package baseball.validate

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class InputValidatorTest {

    @Test
    @DisplayName("숫자 이외의 값을 입력하면 예외가 발생한다.")
    fun inputNotNumberTest() {
        // when
        assertThat(
            assertThrows<IllegalArgumentException>
            { InputValidator.validateNumberFormat("1e3") }
        ).isInstanceOf(IllegalArgumentException::class.java)

    }

    @Test
    @DisplayName("지정된 자릿수의 숫자를 입력하지 않을 시 예외가 발생한다.")
    fun inputSizeTest() {
        assertThat(
            assertThrows<IllegalArgumentException>
            { InputValidator.validateInputNumberSize("123", 4) }
        ).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("중복된 숫자를 입력 시 예외가 발생한다.")
    fun inputDuplicateNumberTest() {
        assertThat(
            assertThrows<IllegalArgumentException>
            { InputValidator.validateNumberDuplicate("122") }
        ).isInstanceOf(IllegalArgumentException::class.java)
    }
}