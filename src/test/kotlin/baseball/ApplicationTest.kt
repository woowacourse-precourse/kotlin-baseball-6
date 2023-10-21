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
    fun `길이 3이하 입력시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12") }
        }
    }

    @Test
    fun `문자 입력시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a!=bㅁ") }
        }
    }

    @Test
    fun `공백 입력시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ") }
        }
    }
    @Test
    fun `중복 숫자 입력시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    @Test
    fun `null 입력 시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(null) }
        }
    }

    @Test
    fun `tab 입력 시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\t") }
        }
    }

    @Test
    fun `enter 입력 시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\n") }
        }
    }

    override fun runMain() {
        main()
    }
}
