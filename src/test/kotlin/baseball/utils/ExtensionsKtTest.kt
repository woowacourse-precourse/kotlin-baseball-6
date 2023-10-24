package baseball.utils

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExtensionsKtTest {

    @ParameterizedTest
    @ValueSource(strings = ["+123", "-1", "0"])
    @DisplayName("isInt()의 includeSign을 true로 설정했을 때, 부호를 포함하는 숫자 문자열을 true로 반환하는지")
    fun isInt_includeSign_true(input: String) {
        assertEquals(input.isInt(includeSign = true), true)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+123", "-1"])
    @DisplayName("isInt()의 includeSign을 false로 설정했을 때, 부호를 포함하는 숫자 문자열을 false로 반환하는지")
    fun isInt_includeSign_false(input: String) {
        assertEquals(input.isInt(includeSign = false), false)
    }

    @Test
    @DisplayName("해당 문자열의 첫 번째 값에 기호를 포함하는지 판별")
    fun containsSign() {
        val trueCase = listOf("+123", "-123")
        val falseCase = listOf("123", "0", "가나다")
        trueCase.forEach { string ->
            assertEquals(string.containsSign(), true)
        }
        falseCase.forEach { string ->
            assertEquals(string.containsSign(), false)
        }
    }
}