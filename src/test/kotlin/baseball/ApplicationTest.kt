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
    fun `숫자입력 중복 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    @Test
    fun `숫자입력 문자 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("ab3") }
        }
    }

    @Test
    fun `숫자입력 0 포함 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("102") }
        }
    }



    override fun runMain() {
        main()
    }
}
