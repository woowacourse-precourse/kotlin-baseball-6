package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.NullPointerException

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
    fun `아무것도 입력하지 않은 경우(엔터 누른 경우)`() {
        assertSimpleTest{
            assertThrows<NullPointerException> { runException("\n") }
        }
    }

    @Test
    fun `중복된 숫자가 있는 경우`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { runException("224") }
        }
    }

    @Test
    fun `숫자가 아닌 문자가 있는 경우`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { runException("x41") }
        }
    }

    @Test
    fun `숫자 중에 0이 포함된 경우`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { runException("501") }
        }
    }

    override fun runMain() {
        main()
    }
}
