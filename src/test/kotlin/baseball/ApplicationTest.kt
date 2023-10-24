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
    fun `예외 테스트 - 부적절한 입력`() {
        // given
        val invalidInputs = listOf("abc", "12a", "12 3", "111")

        // when & then
        invalidInputs.forEach { input ->
            assertThrows<IllegalArgumentException> {
                runException(input)
            }
        }
    }

    @Test
    fun `게임은 정답을 가지고 있습니다`() {
        // given
        val game = BaseballGame()

        // when
        val randomNumber = game.generateRandomNumber()

        // then
        assertThat(randomNumber).hasSize(3)
    }
    override fun runMain() {
        main()
    }
}
