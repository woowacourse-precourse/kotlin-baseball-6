package baseball

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidatorTest {
    @Test
    fun `올바른 수의 개수 유효성 검사`() {
        val numbers = listOf(1, 2, 3)
        val result = Validator.areInvalidCountNumbers(numbers)
        assertFalse(result)
    }

    @Test
    fun `올바르지 않은 수의 개수 유효성 검사`() {
        val numbers = listOf(1, 2, 3, 4)
        val result = Validator.areInvalidCountNumbers(numbers)
        assertTrue(result)
    }

    @Test
    fun `올바른 수의 범위 유효성 검사`() {
        val numbers = listOf(1, 5, 9)
        val result = Validator.areOutOfRangeNumbers(numbers)
        assertFalse(result)
    }

    @Test
    fun `올바르지 않은 수의 범위 유효성 검사`() {
        val numbers = listOf(1, 10, 5)
        val result = Validator.areOutOfRangeNumbers(numbers)
        assertTrue(result)
    }

    @Test
    fun `중복되지 않은 수 유효성 검사`() {
        val numbers = listOf(1, 2, 3)
        val result = Validator.areDuplicateNumbers(numbers)
        assertFalse(result)
    }

    @Test
    fun `중복된 수 유효성 검사`() {
        val numbers = listOf(1, 2, 2)
        val result = Validator.areDuplicateNumbers(numbers)
        assertTrue(result)
    }
}