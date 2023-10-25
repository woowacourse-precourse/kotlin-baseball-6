package baseball.domain

import baseball.constant.ChoiceState
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("게임의 재시작 여부를 확인하는 class의")
class BaseBallGameRestarterTest {

    @Test
    @DisplayName("1 입력시 ChoiceState.Restart을 반환한다")
    fun checkChoiceRestart() {
        //given
        val restarter = BaseBallGameRestarter(1)
        //when
        val restarterChoice = restarter.checkRestartChoice()
        //then
        Assertions.assertThat(restarterChoice).isEqualTo(ChoiceState.RESTART)

    }

    @Test
    @DisplayName("2 입력시 ChoiceState.EXIT을 반환한다")
    fun checkChoiceExit() {
        //given
        val restarter = BaseBallGameRestarter(2)
        //when
        val restarterChoice = restarter.checkRestartChoice()
        //then
        Assertions.assertThat(restarterChoice).isEqualTo(ChoiceState.EXIT)
    }


    @Test
    @DisplayName("다른 숫자 입력시 IllegalArgumentException을 발생시킨다")
    fun initRestarter() {
        //given
        //when
        //then
        Assertions.assertThatThrownBy { BaseBallGameRestarter(4) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }
}