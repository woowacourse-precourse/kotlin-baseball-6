package baseball

class View {
    fun start() {
        println(Message.GUIDE_START)
    }

    fun input() {
        print(Message.GUIDE_INPUT)
    }

    fun end() {
        println(Message.GUIDE_END)
    }

    fun decision() {
        println(Message.GUIDE_DECISION)
    }

    fun announceScore(score: Score) {
        if (score.nothing) {
            println(Message.SCORE_NOTHING)
        } else if (score.ball != 0 && score.strike != 0) {
            println("${score.ball}${Message.SCORE_BALL} ${score.strike}${Message.SCORE_STRIKE}")
        } else if (score.ball != 0 && score.strike == 0) {
            println("${score.ball}${Message.SCORE_BALL}")
        } else {
            println("${score.strike}${Message.SCORE_STRIKE}")
        }

    }
}