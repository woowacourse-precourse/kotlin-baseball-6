package baseball

import baseball.constants.GameConfig
import baseball.model.Answer
import baseball.model.BaseballInput
import baseball.model.MenuInput

class BaseballGame(
    private val answer: Answer,
    private val baseballInput: BaseballInput,
    private val menuInput: MenuInput,
) {
    fun play() {
        var isStay = true
        gameStartPrompt()

        while (isStay) {
            // [2]. 숫자 야구 입력
            inputBaseball(baseballInput)
            val isAllStrike = calculate(baseballInput, answer) // [3]. 계산 및 결과 출력
            when (isAllStrike) {
                true -> gameEndPrompt()
                false -> continue
            }

            // [4]. 메뉴 입력
            inputMenu(menuInput)
            when (menuInput.selectedMenu) {
                GameConfig.MENU_RANGE_FIRST -> answer.newGenerator()
                GameConfig.MENU_RANGE_LAST -> isStay = false
            }
        }
    }
}

fun main() {
    val game = BaseballGame(
        Answer(),
        BaseballInput(),
        MenuInput()
    )
    game.play()
}