package baseball.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("입력받은 숫자의 검증해주는 class에서")
class NumberValidatorTest {
    private val validator = NumberValidator()

    @Test
    @DisplayName("정상적인 숫자를 검증하면 IllegalArgumentException이 발생하지 않는다")
    fun normalNumberTest() {
        //given
        //when
        //then
        Assertions.assertThatNoException().isThrownBy { validator.isNumberFormat("123") }
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 검증하면 IllegalArgumentException이 발생한다")
    fun notNumberTest() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { validator.isNumberFormat("ㄱㄴㄷㄹ") }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("숫자와 문자가 섞인 string을 검증하면 IllegalArgumentException이 발생한다")
    fun mixedInputTest() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { validator.isNumberFormat("1ㄷㄹ") }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}