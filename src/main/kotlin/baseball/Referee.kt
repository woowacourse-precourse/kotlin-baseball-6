package baseball

class Referee(private val answer: Int, private var input: Int, private val listener: ResultListener) {
    private val checkList: MutableList<Result> = mutableListOf()

    init {
        check()
    }

    private fun updateInput(input: Int) {
        this.input = input
    }

    private fun check() {
        val answer = this.answer.toString()
        val input = this.input.toString()

        for(i in answer.indices) {
            if(answer[i]==input[i]) { checkList.add(Result.STRIKE) }
            else if(answer.contains(input[i])) { checkList.add(Result.BALL) }
            else if(!answer.contains(input[i])) { checkList.add(Result.NOTHING) }
        }
        returnResult()
    }

    private fun judge(strike: Int, ball: Int, nothing: Int): Boolean {
        if(strike==3) {
            println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            checkList.clear()
            listener.restartGame()
            return false
        }
        else if(strike==0 && ball!=0) { println("${ball}볼") }
        else if(strike!=0 && ball==0) { println("${strike}스트라이크") }
        else if(strike!=0 && ball!=0) { println("${ball}볼 ${strike}스트라이크") }
        else if(nothing==3) { println("낫싱") }
        return true
    }

    private fun returnResult() {
        val resultsCount = checkList.groupingBy { it }.eachCount()
        val strike = resultsCount[Result.STRIKE] ?: 0
        val ball = resultsCount[Result.BALL] ?: 0
        val nothing = resultsCount[Result.NOTHING] ?: 0

        val continueGame = judge(strike, ball, nothing)
        if(continueGame) { initContinue() }
    }

    private fun initContinue() {
        updateInput(Player(InputManager()).inputNum())
        checkList.clear()
        check()
    }
}