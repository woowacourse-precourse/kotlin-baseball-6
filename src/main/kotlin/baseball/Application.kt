package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun printStartGameSentence() {
    println("숫자 야구 게임을 시작합니다.")
}

fun startGame() {
    startGameUser(getAnswerNumber())
}

fun startGameUser(answerNumber: String) {
    //비교하여 맞을 때까지 진행
    while(true) {
        print("숫자를 입력해주세요 : ")
        val userNumber = Console.readLine().toString()
        //오류가 생기면 Illegal을 발생 시킬것이고, 오류가 없으면 정상적으로 다음 코드를 보게 될 것이다.
        checkUserNumber(userNumber)
    }
}

fun checkUserNumber(userNumber: String) {

    //userNumber길이 체크
    if(userNumber.length != 3) {
        throw IllegalArgumentException("3자리를 입력해주세요")
    }

    val numDuplicateCheckArray = mutableListOf<Char>()

    for(number in userNumber) {
        //숫자가 아닐 경우 체크
        if(number < '1' || number > '9')
            throw IllegalArgumentException("숫자를 입력해주세요")

        //중복된 숫자 체크
        if(numDuplicateCheckArray.contains(number))
            throw IllegalArgumentException("숫자가 중복되지 않게 입력해주세요")

        numDuplicateCheckArray.add(number)
    }
}
fun getAnswerNumber(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    //joinToString(separator,prefix,postfix,limit,truncated,transform)
    return computer.joinToString(separator = "")
}

fun main() {
    printStartGameSentence()
    //게임시작
    startGame()
}