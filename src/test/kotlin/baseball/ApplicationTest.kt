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
    fun `게임 재시작에서 1,2 이외의 입력시`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> { runException("123", "3") }
            },
            1, 2, 3
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `입력 숫자가 1~9 범위 밖의 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("103") }
        }
    }

    @Test
    fun `checkInputThree_테스트 3개 미만`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12") }
        }
    }

    @Test
    fun `checkIsNumber_테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a!=") }
        }
    }

    @Test
    fun `checkDuplicate_테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    @Test
    fun `checkBlank_테스트 공백`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ") }
        }
    }

    @Test
    fun `checkBlank_테스트 null`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(null) }
        }
    }

    @Test
    fun `checkBlank_테스트 tab`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\t") }
        }
    }

    @Test
    fun `checkBlank_테스트 enter`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\n") }
        }
    }

    override fun runMain() {
        main()
    }
}
