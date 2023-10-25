package util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserConsoleTest {

    @Test
    fun `입력 값이 숫자가 아닐 때 예외 발생`() {
        assertThrows<IllegalArgumentException> { UserConsole.validateInput("abc") }
    }

    @Test
    fun `입력 값에 숫자와 문자가 섞여있을 때 예외 발생`() {
        assertThrows<IllegalArgumentException> { UserConsole.validateInput("12a") }
    }

    @Test
    fun `입력 값의 숫자가 범위 밖일 때 예외 발생`() {
        assertThrows<IllegalArgumentException> { UserConsole.validateInput("120") }
    }

    @Test
    fun `입력 값의 길이가 3을 초과할 때 예외 발생`() {
        assertThrows<IllegalArgumentException> { UserConsole.validateInput("1234") }
    }

    @Test
    fun `입력 값의 숫자가 중복될 때 예외 발생`() {
        assertThrows<IllegalArgumentException> { UserConsole.validateInput("112") }
    }

    @Test
    fun `모두 중복된 숫자가 입력 됐을 때 예외 발생`() {
        assertThrows<IllegalArgumentException> { UserConsole.validateInput("111") }
    }


    @Test
    fun `재시작 입력 값이 1, 2가 아닌 숫자일 때 예외 발생`() {
        assertThrows<IllegalArgumentException> { UserConsole.validateRestartInput("3") }
    }

    @Test
    fun `재시작 입력 값이 문자일 때 예외 발생`() {
        assertThrows<IllegalArgumentException> { UserConsole.validateRestartInput("a") }
    }
}