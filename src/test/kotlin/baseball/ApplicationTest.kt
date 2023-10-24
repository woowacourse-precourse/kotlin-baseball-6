package baseball

import baseball.constants.EXCEPTION_DUPLICATION
import baseball.constants.EXCEPTION_EXIT
import baseball.constants.EXCEPTION_RANGE
import baseball.constants.EXCEPTION_SIZE
import baseball.model.Score
import baseball.util.pickBaseBallNumber
import baseball.util.toDigitList
import baseball.util.validateInputBaseBall
import baseball.util.validateInputExit
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

        // when
        val result1 = pickBaseBallNumber()

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
    fun `countBall() 테스트`() {
        // given
        val baseBallGame = BaseBallGame()
        val case1 = listOf(listOf(1, 2, 3), listOf(1, 2, 3))
        val case2 = listOf(listOf(3, 1, 2), listOf(1, 2, 3))
        val case3 = listOf(listOf(1, 5, 6), listOf(1, 2, 3))
        val case4 = listOf(listOf(1, 3, 4), listOf(1, 2, 3))
        val case5 = listOf(listOf(3, 1, 4), listOf(1, 2, 3))

        // when
        val result1 = baseBallGame.countBall(case1[0], case1[1])
        val result2 = baseBallGame.countBall(case2[0], case2[1])
        val result3 = baseBallGame.countBall(case3[0], case3[1])
        val result4 = baseBallGame.countBall(case4[0], case4[1])
        val result5 = baseBallGame.countBall(case5[0], case5[1])

        // then
        assertThat(result1).isEqualTo(0)
        assertThat(result2).isEqualTo(3)
        assertThat(result3).isEqualTo(0)
        assertThat(result4).isEqualTo(1)
        assertThat(result5).isEqualTo(2)
    }

    @Test
    fun `countStrike() 테스트`() {
        // given
        val baseBallGame = BaseBallGame()
        val case1 = listOf(listOf(1, 2, 3), listOf(1, 2, 3))
        val case2 = listOf(listOf(3, 1, 2), listOf(1, 2, 3))
        val case3 = listOf(listOf(1, 5, 6), listOf(1, 2, 3))
        val case4 = listOf(listOf(1, 3, 4), listOf(1, 2, 3))
        val case5 = listOf(listOf(4, 2, 3), listOf(1, 2, 3))

        // when
        val result1 = baseBallGame.countStrike(case1[0], case1[1])
        val result2 = baseBallGame.countStrike(case2[0], case2[1])
        val result3 = baseBallGame.countStrike(case3[0], case3[1])
        val result4 = baseBallGame.countStrike(case4[0], case4[1])
        val result5 = baseBallGame.countStrike(case5[0], case5[1])

        // then
        assertThat(result1).isEqualTo(3)
        assertThat(result2).isEqualTo(0)
        assertThat(result3).isEqualTo(1)
        assertThat(result4).isEqualTo(1)
        assertThat(result5).isEqualTo(2)
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
            .`as`("조건에 맞게 입력한 경우")
            .doesNotThrowAnyException()

        assertThatThrownBy { validateInputBaseBall(case2) }
            .`as`("3개의 수를 입력했는지 확인")
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_SIZE)

        assertThatThrownBy { validateInputBaseBall(case3) }
            .`as`("중복된 수를 입력했는지 확인")
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_DUPLICATION)

        assertThatThrownBy { validateInputBaseBall(case4) }
            .`as`("1~9 범위 내의 수를 입력했는지 확인")
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_RANGE)
    }

    @Test
    fun `printBallAndStrike() 테스트`() {
        // given
        val case1 = Score(1, 1)
        val case2 = Score(0, 0)
        val case3 = Score(2, 0)
        val case4 = Score(0, 3)

        // when
        case1.printBallAndStrike()
        case2.printBallAndStrike()
        case3.printBallAndStrike()
        case4.printBallAndStrike()

        // then
        assertThat(output())
            .contains(
                "1볼 1스트라이크",
                "낫싱",
                "2볼",
                "3스트라이크"
            )
    }

    @Test
    fun `validateInputExit() 테스트`() {
        // given
        val case1 = "0"
        val case2 = "1"
        val case3 = "2"

        // when, then
        assertThatThrownBy { validateInputExit(case1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(EXCEPTION_EXIT)

        assertThatCode { validateInputExit(case2) }
            .doesNotThrowAnyException()

        assertThatCode { validateInputExit(case3) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `isEndGame() 테스트`() {
        // given
        val case1 = Score(3, 0)
        val case2 = Score(1, 1)
        val case3 = Score(0, 3)

        // when
        val result1 = case1.isEndGame()
        val result2 = case2.isEndGame()
        val result3 = case3.isEndGame()

        // then
        assertThat(result1).isEqualTo(false)
        assertThat(result2).isEqualTo(false)
        assertThat(result3).isEqualTo(true)
    }

    @Test
    fun `toDigitList() 테스트`() {
        // given
        val case1 = "123"
        val case2 = "1"
        val case3 = "563"

        // when
        val result1 = case1.toDigitList()
        val result2 = case2.toDigitList()
        val result3 = case3.toDigitList()

        // then
        assertThat(result1).isEqualTo(listOf(1, 2, 3))
        assertThat(result2).isEqualTo(listOf(1))
        assertThat(result3).isEqualTo(listOf(5, 6, 3))
    }

    override fun runMain() {
        main()
    }
}
