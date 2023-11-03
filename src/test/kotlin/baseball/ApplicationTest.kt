package baseball

import baseball.model.BaseBall
import baseball.util.Validator.validateGameStatus
import baseball.util.Validator.validateInteger
import baseball.util.Validator.validateLength
import baseball.util.Validator.validateRange
import baseball.util.Validator.validateUniqueNumber
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
    fun `사용자 입력 3자리 숫자인지 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateLength("1234") }
            assertThrows<IllegalArgumentException> { validateLength("12") }
            assertThrows<IllegalArgumentException> { validateLength("12345") }
            assertThrows<IllegalArgumentException> { validateLength("") }
        }
    }

    @Test
    fun `사용자 입력이 정수인지 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateInteger("12a") }
            assertThrows<IllegalArgumentException> { validateInteger("1!2") }
            assertThrows<IllegalArgumentException> { validateInteger("_+E") }
            assertThrows<IllegalArgumentException> { validateInteger("ab!") }
        }
    }

    @Test
    fun `사용자 입력 중 중복된 수가 없는지 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateUniqueNumber("122") }
            assertThrows<IllegalArgumentException> { validateUniqueNumber("994") }
        }
    }

    @Test
    fun `사용자 입력 중 각자리가 범위에 맞는지 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateRange("012") }
            assertThrows<IllegalArgumentException> { validateRange("980") }
        }
    }

    @Test
    fun `사용자의 입력이 1, 2 인지 검증`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateGameStatus("0") }
            assertThrows<IllegalArgumentException> { validateGameStatus("3") }
            assertThrows<IllegalArgumentException> { validateGameStatus("11") }
        }
    }

    @Test
    fun `사용자의 입력과 컴퓨터의 숫자를 비교 반환 검증`() {
        val baseBall = BaseBall()
        val user = listOf(1, 2, 3)
        val computer = listOf(1, 2, 4)
        baseBall.compareNumber(computer, user)
        val validation = Pair(baseBall.strike, baseBall.ball)
        val result = Pair(2, 0)
        assertThat(validation).isEqualTo(result)
    }

    override fun runMain() {
        main()
    }
}
