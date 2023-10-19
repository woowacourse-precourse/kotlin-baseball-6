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
    fun `pickBaseBallNumber() 테스트`() {
        // given
        val case1 = BaseBallGame()

        // when
        val result1 = case1.pickBaseBallNumber()

        // then
        assertThat(result1.size)
                .`as`("3개의 수를 선택했는지 확인")
                .isEqualTo(3)

        assertThat(result1.distinct().size)
                .`as`("중복된 수가 없는지 확인")
                .isEqualTo(3)

        assertThat(result1.filter { it in 1..9 }.toList().size)
                .`as`("1~9 사이의 수를 선택했는지 확인")
                .isEqualTo(3)
    }

    override fun runMain() {
        main()
    }
}
