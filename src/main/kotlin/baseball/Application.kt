package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.*

var flag = true;
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startGame()
}

fun startGame() {
    val computerNum = testComNum()
    while (flag) {
        print("숫자를 입력해주세요 : ")
        val userNum = createUserNum()
        isCheck(computerNum, userNum)
    }
}

fun testComNum(): MutableList<Int> {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}

fun createUserNum(): String {
    val userInput = Console.readLine()
    if (userInput.length < 2 || userInput.length > 3 ||
            userInput[0] == userInput[1] || userInput[0] == userInput[2] ||
            userInput[1] == userInput[2] || userInput[0] == '0'
    ) {
        throw IllegalArgumentException("중복 되지 않는 1~9 3자리 숫자로 입력해 주세요")
    }
    return userInput
}


fun isCheck(com: MutableList<Int>, user: String) {
    var strike = 0
    var ball = 0
    //print("$com , $user") 입력값 체크
    for (i in 0..2) {
        for (j in 0..2) {
            if (com.elementAt(i) == user[j].toString().toInt()) {
                if (i == j) {
                    strike++
                } else {
                    ball++
                }
            }
        }
    }
    if(strike==0&&ball==0) {
        print("낫싱\n")
    }
    else if (ball == 0) {
        print("" + strike + "스트라이크\n")
    } else if (strike == 0) {
        print("" + ball + "볼\n")
    } else {
        print("" + ball + "볼 " + strike + "스트라이크\n")
    }
    if (strike == 3) {
        print(
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        )
        var input = Console.readLine()
        if (input == "1") {
            flag = true
            startGame()
        } else if (input == "2") {
            flag = false
            print("게임종료")
        } else{
            throw IllegalArgumentException("입력 실수")
        }
    }
}
