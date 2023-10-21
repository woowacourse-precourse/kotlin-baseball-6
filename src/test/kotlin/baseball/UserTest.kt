package baseball

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class UserTest {
    private lateinit var user: User

    @BeforeEach
    fun setUp() {
        user = User()
    }

    @Test
    fun `올바른 입력에 대한 예외가 발생하지 않아야 함`() {
        assertDoesNotThrow { user.generateNumbers("123") }
    }

    @Test
    fun `문자가 포함된 문자열 입력에 대한 예외가 발생해야 함`() {
        assertThrows<IllegalArgumentException> { user.generateNumbers("123a") }
    }

    @Test
    fun `빈문자열 입력에 대한 예외가 발생해야 함`() {
        assertThrows<IllegalArgumentException> { user.generateNumbers("") }
    }

    @Test
    fun `정해진 숫자 개수 미만 입력에 대한 예외가 발생해야 함`() {
        assertThrows<IllegalArgumentException> { user.generateNumbers("1") }
    }

    @Test
    fun `정해진 숫자 개수 초과 입력에 대한 예외가 발생해야 함`() {
        assertThrows<IllegalArgumentException> { user.generateNumbers("1234") }
    }

    @Test
    fun `중복된 숫자 입력에 대한 예외가 발생해야 함`() {
        assertThrows<IllegalArgumentException> { user.generateNumbers("122") }
    }

    @Test
    fun `올바르지 않은 숫자 범위 입력에 대한 예외가 발생해야 함`() {
        assertThrows<IllegalArgumentException> { user.generateNumbers("012") }
    }
}