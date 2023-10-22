package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class GameNumbersTest {
    @Test
    fun `생성실패_입력이 null임`() {
        assertThrows<IllegalArgumentException> { GameNumbers(null) }
    }

    @Test
    fun `생성실패_문자열의 길이가 3이 아님`() {
        assertAll(
            { assertThrows<IllegalArgumentException> { GameNumbers("1") } },
            { assertThrows<IllegalArgumentException> { GameNumbers("23") } },
            { assertThrows<IllegalArgumentException> { GameNumbers("4567") } },
        )
    }

    @Test
    fun `생성실패_중복되는 문자가 존재함`() {
        assertAll(
            { assertThrows<IllegalArgumentException> { GameNumbers("111") } },
            { assertThrows<IllegalArgumentException> { GameNumbers("223") } },
            { assertThrows<IllegalArgumentException> { GameNumbers("455") } },
        )
    }

    @Test
    fun 생성성공() {
        assertAll(
            { assertDoesNotThrow { GameNumbers("123") } },
            { assertDoesNotThrow { GameNumbers("456") } },
            { assertDoesNotThrow { GameNumbers("789") } },
        )
    }

    @Test
    fun `두 GameNumbers 간의 동일한 숫자의 개수를 구한다`() {
        val gameNumbers = GameNumbers("123")
        val otherGameNumbers = GameNumbers("345")

        val count = gameNumbers.countSameNumbers(otherGameNumbers)

        assertThat(count).isEqualTo(1)
    }

    @Test
    fun `두 GameNumbers 간의 같은 위치에 같은 값을 가지는 개수를 구한다`() {
        val gameNumbers = GameNumbers("123")
        val otherGameNumbers = GameNumbers("124")

        val count = gameNumbers.countSameNumberAndPosition(otherGameNumbers)

        assertThat(count).isEqualTo(2)
    }
}