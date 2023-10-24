package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
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
    fun testRandomNumberGeneration() {
        val numberBaseball = NumberBaseball()
        val computerNumber = numberBaseball.input.createComputerNumber()

        // ComputerNumber는 3자리 숫자여야 합니다.
        assertEquals(3, computerNumber.length)
        assertTrue(computerNumber.all { it in '1'..'9' })

        // 중복된 숫자가 없어야 합니다.
        assertTrue(computerNumber[0] != computerNumber[1] && computerNumber[1] != computerNumber[2] && computerNumber[0] != computerNumber[2])
    }

    override fun runMain() {
        NumberBaseball().main()
    }
}
