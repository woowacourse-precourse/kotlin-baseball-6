package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    while(true) {
        playGame()
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n")
        val inputText =Console.readLine()
        if(inputIsInt(inputText)==2) break
    }
}

fun playGame() {
    val computer: MutableList<Int> = generateComputerNumber()
    var inputText: String
    var gameEnd =true
    print("숫자 야구 게임을 시작합니다.")
    while(gameEnd){
        print("\n숫자를 입력해주세요 : ")
        inputText = Console.readLine()
        gameEnd=answerCheck(computer, getUserInput(inputText))
    }
}

fun getUserInput(inputText: String): List<Int>{
    val answer: Int = inputIsInt(inputText)
    validateNumbers(answer)
    return listOf(answer/100 ,answer/10%10, answer%10)
}
fun generateComputerNumber() : MutableList<Int>{
    val computer= mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
fun answerCheck(computer: MutableList<Int>, user: List<Int>): Boolean {
    var ball = 0
    var strike = 0

    for(i in 0 until computer.size)
    {
        if(computer[i]==user[i]){
            strike++
        }
    }
    for(i in 0 until computer.size)
    {
        if(computer.contains(user[i])){
            ball++
        }
    }
    ball-=strike
    print(printGameText(ball, strike))
    if(strike==3) return false
    return true
}

fun printGameText(ball: Int, strike: Int) : String {
    var printAnswer = ""
    if(ball==0 && strike==0) {
        printAnswer="낫싱"
    }
    if (ball > 0) {
        printAnswer = "${ball}볼"
    }
    if (strike > 0) {
        if(ball>0) printAnswer+=" "
        printAnswer += "${strike}스트라이크"
    }
    if (strike == 3) {
        printAnswer += "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    }
    return printAnswer
}

fun inputIsInt(str: String): Int {
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(" ${str}는 숫자가 아닙니다.")
    }
}

fun validateNumbers(answer: Int){
    if (answer > 999 || answer<100) {
        throw IllegalArgumentException("${answer}는 3자리의 수가 아닙니다.")
    }
}
