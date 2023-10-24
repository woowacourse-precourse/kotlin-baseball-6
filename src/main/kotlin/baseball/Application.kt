package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import javax.swing.text.html.HTML.Tag.I

var userInput = ""
var userNumber = 0
var intOne = 0
var intTwo = 0
var intThree = 0
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
        userInputCheck(userInput)
    } catch (e: NumberFormatException) { // 문자열을 입력할 경우
        throw IllegalArgumentException("문자가 아닌 숫자를 입력하세요.")
    }

    intOne = userNumber/100
    intTwo = (userNumber%100)/10
    intThree = userNumber%10

    user.add(intOne)
    user.add(intTwo)
    user.add(intThree)

    return user
}

fun userInputCheck(userInput: String) {
    val user: MutableList<Char> = mutableListOf()
    if(userInput.length != 3) // 3자리 정수가 아닐 경우
        throw IllegalArgumentException("3자리 정수를 입력하세요.")

    for(i: Int in 0 until NUMBER_SIZE)
        user.add(userInput[i])

    for(i in user.indices) { // 중복된 숫자를 입력할 경우
        for(j in i+1 until user.size) {
            if(user[i] == user[j])
                throw IllegalArgumentException("중복되지 않는 숫자를 입력하세요.")
        }
    }
}


