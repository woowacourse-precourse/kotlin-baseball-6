package baseball

class BaseballOperate {
    private val baseball = BaseballReady()
    fun baseballPlay() : Boolean {
        while(true){
            print("숫자를 입력해 주세요 : ")
            baseball.setInputNumber()

            if(baseball.rangeCheck()) {
                println("범위가 잘못되었습니다.")
                return false
            }
            baseball.checkStrike()
            baseball.checkBall()
            baseball.checkNothing()

            baseball.printStrikeBall()
            if(baseball.checkAnswer()) {
                break
            }
            baseball.initBallStrike()
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
}