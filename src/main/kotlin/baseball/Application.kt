package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import javax.swing.text.html.HTML.Tag.I

var userInput = ""
var userNumber = 0
var int_one = 0
var int_two = 0
var int_three = 0
const val NUMBER_SIZE = 3

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var strike = 0
    var computer = getRandomNumbers()
    var user = getUserNumbers()

}

fun getRandomNumbers(): MutableList<Int> { // 랜덤값 얻기
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < NUMBER_SIZE) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserNumbers(): MutableList<Int> { // 사용자 입력값 얻기
    print("숫자를 입력해주세요 : ")
    val user: MutableList<Int> = mutableListOf()
    userInput = Console.readLine()

    try {
        userNumber = userInput.toInt()
        //userInputCheck(userInput)
    } catch (e: NumberFormatException) { // 문자를 입력할 경우
        throw IllegalArgumentException("문자가 아닌 숫자를 입력하세요.")
    }

    int_one=userNumber/100
    int_two= (userNumber%100)/10
    int_three=userNumber%10

    user.add(int_one)
    user.add(int_two)
    user.add(int_three)

    return user
}




