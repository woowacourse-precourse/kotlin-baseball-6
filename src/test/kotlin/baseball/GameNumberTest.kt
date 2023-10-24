package baseball

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class GameNumberTest {
    @Test
    fun `생성실패_1부터 9까지의 수가 아닌 문자임`() {
        assertAll(
            { assertThrows<IllegalArgumentException> { GameNumber('0') } },
            { assertThrows<IllegalArgumentException> { GameNumber('a') } },
            { assertThrows<IllegalArgumentException> { GameNumber('가') } },
        )
    }

    @Test
    fun 생성성공() {
        assertAll(
            { assertDoesNotThrow { GameNumber('1') } },
            { assertDoesNotThrow { GameNumber('5') } },
            { assertDoesNotThrow { GameNumber('9') } },
        )
    }
}
