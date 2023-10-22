package baseball

import baseball.util.GameMessage
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
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
    fun `길이를 벗어난 입력 예외 테스트`(){
        assertSimpleTest{
            val exception = assertThrows<IllegalArgumentException>{runException("23123124")}
            assertEquals(GameMessage.GAME_ERROR_INPUT_LENGTH,exception.message)
        }
    }
    @Test
    fun `숫자가 아닌 경우 입력 예외 테스트`() {
        assertSimpleTest{
            val exception = assertThrows<IllegalArgumentException> { runException("abc") }
            assertEquals(GameMessage.GAME_ERROR_INPUT_NUMBER, exception.message)
        }
        assertSimpleTest{
            val exception = assertThrows<IllegalArgumentException> { runException("우테코") }
            assertEquals(GameMessage.GAME_ERROR_INPUT_NUMBER, exception.message)
        }
        assertSimpleTest{
            val exception = assertThrows<IllegalArgumentException> { runException("!@$") }
            assertEquals(GameMessage.GAME_ERROR_INPUT_NUMBER, exception.message)
        }
    }
    @Test
    fun `중복된 숫자 입력 예외 테스트`(){
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("222") }
            assertEquals(GameMessage.GAME_ERROR_INPUT_DUPLICATE,exception.message)
        }
    }

    override fun runMain() {
        main()
    }
}
