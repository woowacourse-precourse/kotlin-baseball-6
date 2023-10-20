package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `게임종료 후 재시작`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `게임종료 후 재시작2`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "1", "958", "123", "189", "985", "579", "487", "589", "2")
                assertThat(output())
                    .contains("3스트라이크", "3볼", "낫싱", "2스트라이크", "2볼 1스트라이크", "2스트라이크", "1스트라이크", "3스트라이크", "게임 종료")
            },
            2, 4, 6, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
            assertThrows<IllegalArgumentException> { runException("abc") }
            assertThrows<IllegalArgumentException> { runException("12") }
            assertThrows<IllegalArgumentException> { runException("122") }
            assertThrows<IllegalArgumentException> { runException("1223") }
            assertThrows<IllegalArgumentException> { runException("1 3") }
            assertThrows<IllegalArgumentException> { runException("1 3 5") }
        }
    }

    override fun runMain() {
        main()
    }
}