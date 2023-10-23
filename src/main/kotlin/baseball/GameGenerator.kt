package baseball

class BaseballOperate {
    val baseball = BaseballReady()
    fun BaseballPlay() : Boolean {
        while(true){
            print("숫자를 입력해 주세요 : ")
            baseball.setInputNumber()

            if(baseball.RangeCheck()) {
                println("범위가 잘못되었습니다.")
                return false
            }
            baseball.CheckStrike()
            baseball.CheckBall()
            baseball.CheckNothing()

            baseball.PrintStrikeBall()
            if(baseball.CheckAnswer()) {
                break
            }
            baseball.InitBallStrike()
        }
        baseball.InitRandomNumber()
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
}