package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.io.LineNumberReader
import java.util.*
import kotlin.math.ceil

var flag = true;
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    startGame()
}

//야구게임 시작
fun startGame() {
    val computerNum = testComNum()
    while (flag) {
        print("숫자를 입력해주세요 : ")
        val userNum = createUserNum()
        isCheck(computerNum, userNum)
    }
}

//컴퓨터 랜덤 숫자
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

//사용자에게 입력 받는 함수
fun createUserNum(): String {
    val userInput = Console.readLine()
    if (isNum(userInput)|| isInputCheck(userInput)){
        throw IllegalArgumentException("유효 하지 않은 형식 입니다.")
    }
    return userInput
}

//입력값이 3개 또는 앞자리가 0인 것 체크
fun isInputCheck(string:String):Boolean{
    var check = false
    if(string.length!=3||string[0]==string[1]||string[1]==string[2]||string[0]==string[2]||string[0]=='0'){
        check = true
        return check
    }
    return check
}

// 1~9를 제외한 다른 값 체크
fun isNum(string:String):Boolean{
    var check = false
    if(string.contains("""[^123456789]""".toRegex())){
        check = true
        return check
    }else{
        return check
    }
}

//입력 받은 숫자 비교
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
        val input = Console.readLine()
        when (input) {
            "1" -> {
                flag = true
                startGame()
            }
            "2" -> {
                flag = false
                print("게임종료")
            }
            else -> {
                throw IllegalArgumentException("입력 실수")
            }
        }
    }
}
