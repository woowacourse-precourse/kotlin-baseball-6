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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `입력 숫자 개수 검증 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1") }
            assertThrows<IllegalArgumentException> { runException("12") }
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `입력 숫자 타입 검증 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abc") }
            assertThrows<IllegalArgumentException> { runException("a12") }
            assertThrows<IllegalArgumentException> { runException("12a") }
        }
    }

    @Test
    fun `입력 숫자 범위 검증 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("000") }
            assertThrows<IllegalArgumentException> { runException("012") }
            assertThrows<IllegalArgumentException> { runException("120") }
        }
    }

    @Test
    fun `입력 숫자 중복 검증 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
            assertThrows<IllegalArgumentException> { runException("121") }
            assertThrows<IllegalArgumentException> { runException("211") }
        }
    }

    override fun runMain() {
        main()
    }
}
