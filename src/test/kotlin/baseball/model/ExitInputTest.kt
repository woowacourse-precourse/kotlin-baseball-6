package baseball.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExitInputTest {

    @ParameterizedTest
    @ValueSource(strings = ["안녕하세요", "", "12"])
    fun `1이나 2가 아닌 다른 값을 입력함`(input: String) {
        assertThrows<IllegalArgumentException> {
            ExitInput(input)
        }
    }

    @Test
    fun `1를 입력했을 때, false를 반환`() {
        assert(!ExitInput("1").isExit())
    }

    @Test
    fun `2를 입력했을 때, true를 반환`() {
        assert(ExitInput("2").isExit())
    }
}