package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.Exception

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    //실행 중 여부 판단을 위한 변수
    var isRunning = true
    var inGame = true

    while(isRunning) {
        //랜덤 숫자 지정
        var randomNum = createRandomNum()
        while (inGame) {
            print("숫자를 입력해주세요 : ")
            val userInput = Console.readLine()

            //답변의 유효성 확인
            checkAvailability(userInput)

            //숫자 비교
            val result = compareNum(userInput, randomNum)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                val finishCode = Console.readLine()

                //랜덤 숫자 재생성, 게임 종료
                if (finishCode == "1") {
                    break
                }
                else if (finishCode == "2") {
                    isRunning = false
                    inGame = false
                }
                //답변 유효성 확인
                else {
                    throwException()
                }

            }

        }
    }
}

//서로 다른 세 수를 뽑는 Function
fun createRandomNum() : String {
    val numList = ArrayList<Int>()
    while (numList.size<3) {
        val num = Randoms.pickNumberInRange(1, 9)
        if (!numList.contains(num)) {
            numList.add(num)
        }
    }

    return numList.joinToString("")
}

//랜덤 숫자와 입력 숫자를 비교
fun compareNum(userNum : String, randomNum : String) : String {
    var strike= 0
    var ball= 0

    for (i in 0..2) {
        if(userNum[i] == randomNum[i]) {
            strike++
        }
        else if(userNum[i] in randomNum) {
            ball++
        }
    }

    var answer= ""

    when {
        strike > 0 && ball > 0 -> answer = "${ball}볼 ${strike}스트라이크"
        strike == 0 && ball > 0 -> answer = "${ball}볼"
        strike > 0 && ball == 0 -> answer = "${strike}스트라이크"
        strike == 0 && ball == 0 -> answer = "낫싱"
    }
    return answer
}

fun checkAvailability(userInput : String) {
    if (userInput.length != 3 || userInput.toIntOrNull() == null || userInput.contains("0")) {
        throwException()
    }
    else if(userInput.toSet().size != userInput.length) {
        throwException()
    }
}

fun throwException() {
    throw Exception("IllegalArgumentException")
}