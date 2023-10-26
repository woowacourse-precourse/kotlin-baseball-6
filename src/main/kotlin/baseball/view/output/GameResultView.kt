package baseball.view.output

import baseball.domain.GameResult
import baseball.domain.Hint
import io.Renderable

class GameResultView(
    private val gameResult: GameResult,
) : Renderable {
    override fun render(): String {
        if (gameResult.ballCount + gameResult.strikeCount == 0) {
            return Hint.NOTHING.value
        }
        return listOf(
            renderHint(Hint.BALL, gameResult.ballCount),
            renderHint(Hint.STRIKE, gameResult.strikeCount),
        ).joinToString(" ")
            .trim() +
                LINE_BREAK
    }

    private fun renderHint(hint: Hint, count: Int) =
        when (count) {
            0 -> EMPTY
            else -> "$count${hint.value}"
        }

    companion object {
        const val EMPTY = ""
        const val LINE_BREAK = "\n"
    }
}