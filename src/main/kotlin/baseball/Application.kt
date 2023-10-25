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
            // [2]. baseball / 입력, 검증
            inputBaseballWithValidator(baseballInput)
            // [3]. baseball / 계산, 결과 출력
            val isAllStrike = calculateBaseball(baseballInput, answer)
            when (isAllStrike) {
                true -> gameEndPrompt()
                false -> continue
            }

            // [4]. menu / 입력, 검증 및 처리
            inputMenuWithValidator(menuInput)
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