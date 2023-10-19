package baseball

import baseball.util.validateInputBaseBall
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
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

    @Test
    fun `isBall() 테스트`() {
        // given
        val baseBallGame = BaseBallGame()
        val case1 = listOf(1, 2, listOf(1, 2, 3))
        val case2 = listOf(1, 3, listOf(1, 2, 3))
        val case3 = listOf(1, 1, listOf(1, 2, 3))

        // when
        val result1 = baseBallGame.isBall(case1[0] as Int, case1[1] as Int, case1[2] as List<Int>)
        val result2 = baseBallGame.isBall(case2[0] as Int, case2[1] as Int, case2[2] as List<Int>)
        val result3 = baseBallGame.isBall(case3[0] as Int, case3[1] as Int, case3[2] as List<Int>)

        // then
        assertThat(result1).isEqualTo(false)
        assertThat(result2).isEqualTo(true)
        assertThat(result3).isEqualTo(true)
    }

    @Test
    fun `validateInputBaseBall() 테스트`() {
        // given
        val case1 = listOf(1, 2, 3)
        val case2 = listOf(1, 2, 3, 4)
        val case3 = listOf(1, 2, 2)
        val case4 = listOf(1, 2, 0)

        // when, then
        assertThatCode { validateInputBaseBall(case1) }
                .doesNotThrowAnyException()

        assertThatThrownBy { validateInputBaseBall(case2) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("3개의 숫자를 입력해주세요.")

        assertThatThrownBy { validateInputBaseBall(case3) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("중복되지 않는 숫자를 입력해주세요.")

        assertThatThrownBy { validateInputBaseBall(case4) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("1~9 사이의 숫자를 입력해주세요.")
    }

    override fun runMain() {
        main()
    }
}
