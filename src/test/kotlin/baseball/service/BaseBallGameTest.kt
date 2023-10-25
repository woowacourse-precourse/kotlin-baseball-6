package baseball.service

import baseball.constant.ChoiceState
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("게임의 service class의 ")
class BaseBallGameTest {
    private val baseBallGame = BaseBallGame()

    @Test
    @DisplayName("restartChoice에서 restart 선택시 ChoiceState.Restart를 반환한다")
    fun choiceRestart() {
        //given
        val userChoice = 1
        //when
        val userChoiceState = baseBallGame.restartChoice(userChoice)
        //then
        Assertions.assertThat(userChoiceState).isEqualTo(ChoiceState.RESTART)
    }

    @Test
    @DisplayName("restartChoice에서 Exit 선택시 ChoiceState.Exit을 반환한다")
    fun choiceExit() {
        //given
        val userChoice = 2
        //when
        //then
        val userChoiceState = baseBallGame.restartChoice(userChoice)
        Assertions.assertThat(userChoiceState).isEqualTo(ChoiceState.EXIT)
    }

    @Test
    @DisplayName("restartChoice에서 그외의 선택시 IllegalArgumentException이 발생한다")
    fun choiceOther() {
        //given
        val userChoice = 4
        //when
        //then
        Assertions.assertThatThrownBy { baseBallGame.restartChoice(userChoice) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
    }

}