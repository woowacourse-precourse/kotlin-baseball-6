package baseball

import camp.nextstep.edu.missionutils.Randoms
import org.w3c.dom.ranges.Range

const val MIN = 123
const val MAX = 987

class BaseballOperate {
    private var inputNumber = ""
    private var randomNumber = Randoms.pickNumberInRange(MIN, MAX).toString()
    private var strike = 0
    private var ball = 0
    fun RangeCheck() : Boolean {
        var check = false
        // code
        return check
    }
    fun InitRandomNumber() {
        randomNumber = Randoms.pickNumberInRange(MIN, MAX).toString()
    }
    fun setInputNumber() {
        inputNumber = readLine().toString()
    }
    fun InitBallStrike(){
        strike = 0
        ball = 0
    }
    fun BaseballPlay() {
        while(true){
            print("숫자를 입력해 주세요 : ")
            setInputNumber()

            if(RangeCheck()) {
                println("범위가 잘못되었습니다. 다시 입력해주세요.")
                return
            }
            CheckStrike()
            CheckBall()
            CheckNothing()

            PrintStirkeBall()
            if(CheckAnswer()) {
                break
            }
            InitBallStrike()
        }
        InitRandomNumber()
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return
    }
    fun CheckStrike() {
        for( i in 0..2) {
            if (inputNumber[i] == randomNumber[i]) {
                strike += 1
            }
        }
    }
    fun CheckBall() {
        for(i in 0..2) {
            for(j in 0..2){
                if(i == j) continue
                if(inputNumber[i] == randomNumber[j]) {
                    ball += 1
                }
            }
        }
    }

    fun CheckNothing() :Boolean {
        var checkNothing = false

        if(strike == 0 && ball == 0) {
            println("낫싱")
            checkNothing = true
        }
        return checkNothing
    }
    fun PrintStirkeBall() {
        if (strike == 0 && ball == 0) return
        else if(strike == 0)
        {
            println("${ball}볼")
        }
        else if(ball == 0) {
            println("${strike}스트라이크 ")
        }
        else{
            println("${strike}스트라이크 ${ball}볼")
        }

    }

    fun CheckAnswer(): Boolean {
        if (strike == 3) {
            return true
        }
        else {
            return false
        }
    }
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var gameCoin = 1
    while(gameCoin == 1) {
        val baseballGame = BaseballOperate()
        baseballGame.BaseballPlay()

        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        gameCoin = readLine()!!.toInt()
    }

}

/*
* 추가할 부분
* 1. 같은 숫자 (ex. 111, 998, 997 등등) 에 대해서 예외 처리
*
* */
