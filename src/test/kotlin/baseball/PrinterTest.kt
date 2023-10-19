package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PrinterTest : NsTest() {

    @Test
    fun `스트라이크와 볼이 모두 0인 경우 낫싱을 출력한다`() {
        val printer = Printer()
        val judgeResult = JudgeResult(strikes = 0, balls = 0)
        printer.printJudgeResult(judgeResult)
        Assertions.assertThat(output()).contains("낫싱")
    }

    @Test
    fun `스트라이크만 있는 경우 정상적으로 출력한다`() {
        val printer = Printer()
        val judgeResult = JudgeResult(strikes = 2)
        printer.printJudgeResult(judgeResult)
        Assertions.assertThat(output()).contains("${judgeResult.strikes}스트라이크")
    }

    @Test
    fun `볼만 있는 경우 정상적으로 출력한다`() {
        val printer = Printer()
        val judgeResult = JudgeResult(balls = 2)
        printer.printJudgeResult(judgeResult)
        Assertions.assertThat(output()).contains("${judgeResult.balls}볼")
    }

    @Test
    fun `스트라이크와 볼이 모두 있는 경우 정상적으로 출력한다`() {
        val printer = Printer()
        val judgeResult = JudgeResult(balls = 2, strikes = 1)
        printer.printJudgeResult(judgeResult)

        val expected = "${judgeResult.balls}볼 ${judgeResult.strikes}스트라이크"
        Assertions.assertThat(output()).contains(expected)
    }

    override fun runMain() {
    }
}
