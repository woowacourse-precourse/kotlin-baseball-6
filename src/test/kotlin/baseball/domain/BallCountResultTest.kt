package baseball.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("게임의 ballcount 결과를 갖는 class에")
class BallCountResultTest {

    @Test
    @DisplayName("strike수를 증가시키면 1이 더해진다")
    fun addStrike() {
        //given
        val ballCountResult = BallCountResult()
        val beforeStrike = ballCountResult.countStrike()
        //when
        ballCountResult.addStrike()
        //then
        val afterStrike = ballCountResult.countStrike()
        Assertions.assertThat(afterStrike).isEqualTo(beforeStrike + 1)
    }

    @Test
    @DisplayName("ball수를 증가시키면 1이 더해진다")
    fun addBall() {
        //given
        val ballCountResult = BallCountResult()
        val beforeBall: Int = ballCountResult.countBall()
        //when
        ballCountResult.addBall()
        //then
        val afterBall = ballCountResult.countBall()
        Assertions.assertThat(afterBall).isEqualTo(beforeBall + 1)
    }

    @Test
    @DisplayName("생성한 초기의 strike수를 받을 수 있다")
    fun countStrike() {
        //given
        val ballCountResult = BallCountResult()
        //when
        val strike = ballCountResult.countStrike()
        //then
        Assertions.assertThat(strike).isEqualTo(0)
    }

    @Test
    @DisplayName("생성한 초기의 ball의 수를 받을 수 있다")
    fun countBall() {
        //given
        val ballCountResult = BallCountResult()
        //when
        val ball = ballCountResult.countBall()
        //then
        Assertions.assertThat(ball).isEqualTo(0)
    }

}