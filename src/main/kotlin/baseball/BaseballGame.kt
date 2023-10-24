package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.pow

class BaseballGame {
    // 맞춰야하는 숫자 개수
    private val BALL_NUM= 3
    // 생성된 숫자 리스트
    private val computer: MutableList<Int> = mutableListOf()

    // 입력 받은 숫자를 담은 리스트
    private val guessNum: MutableList<Int> = mutableListOf()


    //게임 실행하는 함수
    // 입력 : X
    // 출력 : X
    fun playGame() {
        do {
            // 야구 게임 시작
            println("숫자 야구 게임을 시작합니다.")
            // 랜덤한 3개의 숫자 생성
            createNumber()
            do {
                // 숫자 추론 하기
                guessNumber()
                // 정답인지 확인
                val check = checkNum()
            }
            // 정답이 아닌 경우 반복
            while (check)
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val restartNum = Console.readLine()?.toInt() ?: 0
            // 1인경우 재시작, 2인 경우 종료
            // 1 또는 2가 아닌 경우 예외 처리
            val resart = when (restartNum) {
                1 -> true
                2 -> false
                else -> throw IllegalArgumentException("1또는 2를 입력 하세요.")
            }
        }
        //재시작을 원하는 경우 다시 실행
        while (resart)
    }

    //컴퓨터가 랜덤한 3개의 숫자를 생성하는 함수
    // 입력 : X
    // 출력 : X
    private fun createNumber() {
        //생성전에 리스트 비우기
        computer.clear()
        while (computer.size < BALL_NUM) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }

    //받은 inputNum이 오류가 있는지 확인하는 함수
    // 입력 : inputNum
    // 출력 : X
    // 예외 : 잘못된 입력을 받는 경우 "IllegalArgumentException" 발생
    private fun checkInputNum(inputNum:Int){
        // 4자리 이상의 숫자 또는 0 이하의 숫자  입력 시 오류 발생
        if (inputNum >= (10.0).pow(BALL_NUM) || inputNum < 1) {
            throw IllegalArgumentException("${BALL_NUM}자리의 숫자를 입력해 주세요.")
        }
    }

    //받은 pickNumber 오류가 있는지 확인하는 함수
    // 입력 : pickNumber
    // 출력 : X
    // 예외 : 잘못된 입력을 받는 경우 "IllegalArgumentException" 발생
    private fun checkPickNumber(pickNumber:Int){
        // 0이 포함되는 경우 오류 발생
        if (pickNumber == 0) {
            throw IllegalArgumentException("0이 포함될 수 없습니다.")
        }
        // 중복된 숫작가 있는 경우 오류 발생
        else if (guessNum.contains(pickNumber)) {
            throw IllegalArgumentException("서로 다른 수를 넣어야합니다.")
        }
    }

    //3자리의 숫자를 입력 받는 함수
    // 입력 : X
    // 출력 : inputNum 입력 받은 숫자
    // 예외 : 잘못된 입력을 받는 경우 "IllegalArgumentException" 발생
    private fun scanInputNum():Int{
        val inputNum: Int
        print("숫자를 입력해주세요 : ")
        try {
            inputNum = Console.readLine()?.toInt() ?: 0
        } catch (ex: NumberFormatException) {
            throw IllegalArgumentException("숫자를 입력해 주세요")
        }
        return inputNum
    }

    //3자리의 숫자를 입력 받는 함수
    // 입력 : X
    // 출력 : X
    // 예외 : 잘못된 입력을 받는 경우 "IllegalArgumentException" 발생
    private fun guessNumber() {
        guessNum.clear()
        var inputNum =scanInputNum()

        checkInputNum(inputNum)

        // 입력 받은 3자리의 숫자를 리스트에 삽입
        while (guessNum.size < BALL_NUM) {
            val pickNumber = inputNum % 10
            checkPickNumber(pickNumber)
            inputNum /= 10
            guessNum.add(0, pickNumber)
        }
    }

    // strike인지 확인하는 함수
    // 입력 : 확인할 자리 수 : Int, 현재 strike 수 : Int
    // 출력 : strike 수 : Int
    private fun checkStrike(num:Int,strike:Int):Int{
        // 위치와 숫자가 동일한 경우
        if (guessNum[num] == computer[num]) {
            return strike +1
        }
        return strike
    }
    // ball인지 확인하는 함수
    // 입력 : 확인할 자리 수 : Int, 현재 ball 수 : Int
    // 출력 : ball 수 : Int
    private fun checkBall(num:Int,ball:Int):Int{
        // 숫자는 동일하지만 자리가 틀린 경우
        for (j: Int in 0..(BALL_NUM-1)) {
            if (num==j) continue
            if (guessNum[num] == computer[j]) {
                return ball+1
            }
        }
        return ball
    }
    // 입력 받은 숫자를 판단해주는 함수
    // 입력 : X
    // 출력 : 맞춘 경우 false, 틀린 경우 true를 출력
    //  - 자리와 숫자가 일치하는 경우 1스트라이크 추가
    //  - 자리가 틀리고 숫자가 존재하는 경우 1볼 추가
    //  - 전부 다 틀린 경우 낫싱 출력
    private fun checkNum(): Boolean {
        var strike = 0
        var ball = 0
        for (i: Int in 0..(BALL_NUM-1)) {
            // i가 strike인지 확인
            strike=checkStrike(i,strike)
            // i가 ball인지 확인
            ball=checkBall(i,ball)
        }
        //볼이 있는 경우
        if (ball != 0) {
            //볼도 있고 스트라이크도 있는 경우
            if (strike != 0) {
                println("${ball}볼 ${strike}스트라이크")
            }
            //볼만 있는 경우
            else if (strike == 0) {
                println("${ball}볼")
            }
        }
        //스트라이크만 있는 경우
        else if (strike != 0) {
            println("${strike}스트라이크")
            if (strike == BALL_NUM) {
                println("${BALL_NUM}개의 숫자를 모두 맞히셨습니다! 게임 종료")
                return false
            }
        }
        //아무 것도 없는 경우
        else if ((strike == 0) && (ball == 0)) {
            println("낫싱")
        }
        return true
    }

}