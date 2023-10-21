package baseball

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidatorTest {
    @Test
    fun `올바른 수의 개수 유효성 검사`() {
        val result = Validator.areInvalidCountNumbers(listOf(1, 2, 3))
        assertFalse(result)
    }

    @Test
    fun `올바르지 않은 수의 개수 유효성 검사`() {
        val result = Validator.areInvalidCountNumbers(listOf(1, 2, 3, 4))
        assertTrue(result)
    }

    @Test
    fun `올바른 수의 범위 유효성 검사`() {
        val result = Validator.areOutOfRangeNumbers(listOf(1, 5, 9))
        assertFalse(result)
    }

    @Test
    fun `올바르지 않은 수의 범위 유효성 검사`() {
        val result = Validator.areOutOfRangeNumbers(listOf(1, 10, 5))
        assertTrue(result)
    }

    @Test
    fun `중복되지 않은 수 유효성 검사`() {
        val result = Validator.areDuplicateNumbers(listOf(1, 2, 3))
        assertFalse(result)
    }

    @Test
    fun `중복된 수 유효성 검사`() {
        val result = Validator.areDuplicateNumbers(listOf(1, 2, 2))
        assertTrue(result)
    }

    @Test
    fun `문자열인에 숫자가 아닌 문자가 있는지 유효성 검사`() {
        val result = Validator.isInvalidNumericInput("1h3")
        assertTrue(result)
    }

    @Test
    fun `문자열인에 숫자 문자만 있는지 유효성 검사`() {
        val result = Validator.isInvalidNumericInput("123")
        assertFalse(result)
    }

    @Test
    fun `빈 문자열인지 유효성 검사`() {
        val result = Validator.isBlankInput("")
        assertTrue(result)
    }

    @Test
    fun `빈 문자열이 아닌지 유효성 검사`() {
        val result = Validator.isBlankInput("ㅇ")
        assertFalse(result)
    }
}