package baseball

import camp.nextstep.edu.missionutils.test.Assertions.*
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GameTest : NsTest() {

    @Test
    fun `한 번에 정답을 입력하고 게임을 종료한다`() {
        assertRandomNumberInRangeTest(
            {
                run("123", "2")
                assertThat(output())
                    .contains(
                        "숫자 야구 게임을 시작합니다.",
                        "숫자를 입력해주세요 :",
                        "3스트라이크",
                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
                    )
            },
            1, 2, 3
        )
    }

    @ParameterizedTest
    @CsvSource(value = ["12", "1234", "023", "가23", "3 6 9"])
    fun `게임 숫자 입력 예외 테스트`(input: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(input) }
        }
    }

    @ParameterizedTest
    @CsvSource(value = ["3", "11", "12", "가"])
    fun `재시작 여부 입력 예외 테스트`(input: String) {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> { runException("123", input) }
            },
            1, 2, 3
        )
    }

    @Test
    fun `볼카운트 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("456", "231", "132", "123", "2")
                assertThat(output())
                    .contains(
                        "낫싱",
                        "3볼",
                        "2볼 1스트라이크",
                        "3스트라이크",
                    )
            },
            1, 2, 3
        )
    }

    override fun runMain() {
        val game = Game()

        game.start()
    }
}