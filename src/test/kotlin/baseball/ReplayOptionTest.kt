package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class ReplayOptionTest {
    @Test
    fun `생성실패_입력이 null임`() {
        assertThrows<IllegalArgumentException> { ReplayOption.from(null) }
    }

    @Test
    fun `생성실패_1 또는 2가 아님`() {
        assertAll(
            { assertThrows<IllegalArgumentException> { ReplayOption.from("0") } },
            { assertThrows<IllegalArgumentException> { ReplayOption.from("345") } },
            { assertThrows<IllegalArgumentException> { ReplayOption.from("입력값") } },
        )
    }

    @Test
    fun `생성성공_입력값이 1이면 REPLAY를 반환한다`() {
        val replayOption = ReplayOption.from("1")

        assertThat(replayOption).isEqualTo(ReplayOption.REPLAY)
    }

    @Test
    fun `생성성공_입력값이 2이면 EXIT를 반환한다`() {
        val replayOption = ReplayOption.from("2")

        assertThat(replayOption).isEqualTo(ReplayOption.EXIT)
    }
}