package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStart()
    baseball()
}
/* 플레이어의 라운드 기록 구조체 Round */
data class Round(var strike: Int = 0, var ball: Int = 0)

/* 숫자 야구 시작 메세지 function : printStart */
fun printStart(){
    println("숫자 야구 게임을 시작합니다.")
}

/* 숫자 야구 진행 function : baseball */
fun baseball(){
    while(true){
        val computer = getComputerNumber()
        while(true){
            val player = getPlayerNumber()
            val roundResult: Round = compareList(computer, player)
            printHint(roundResult)
            if(roundResult.strike == 3) break
        }
        if(!(askRetry())) break
    }
}

/* 상대방 랜덤 수 생성 function : getComputerNumber */
fun getComputerNumber(): List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1,9)
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber)
        }
    }

    return computer
}

/* 플레이어 입력 처리 function : getPlayerNumber */
fun getPlayerNumber(): List<Int> {
    val player = mutableListOf<Int>()

    print("숫자를 입력해주세요 : ")
    val testNumber = readLine()
    val verifiedNumber = checkNumber(testNumber)
    for (char in verifiedNumber) {
        val digit = char.toString().toInt()
        player.add(digit)
    }

    return player
}

/* 플레이어가 잘못된 값을 입력한 경우 function : ChckNumber */
fun checkNumber(testNumber: String?): String{
    if (testNumber.isNullOrBlank()) {
        throw IllegalArgumentException("잘못된 입력입니다, 공백입니다.")
    }
    testNumber.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력입니다, 올바른 숫자가 아닙니다.")
    if (testNumber.length < 3 || testNumber.length > 3) {
        throw IllegalArgumentException("잘못된 입력입니다, 숫자는 3자리이여야 합니다.")
    }
    for (char in testNumber) {
        val digit = char.toString().toIntOrNull()
        if (digit == null || digit < 1 || digit > 9) {
            throw IllegalArgumentException("잘못된 입력입니다, 올바른 범위의 숫자가 아닙니다.")
        }
    }
    val uniqueDigits = testNumber.toSet()
    if (uniqueDigits.size != testNumber.length) {
        throw IllegalArgumentException("잘못된 입력입니다, 중복된 숫자가 존재합니다.")
    }

    return testNumber
}

/* 라운드 조건 검사 function : compareList */
fun compareList(computer: List<Int>, player: List<Int>): Round{
    val roundResult = Round()

    for (i in computer.indices) {
        for (j in player.indices) {
            if (computer[i] == player[j]) {
                if (i == j) {
                    roundResult.strike++
                } else {
                    roundResult.ball++
                }
            }
        }
    }
    return roundResult
}

/* 라운드 조건 검사 결과 출력 function : printHint*/
fun printHint(roundResult: Round){
    val hint = when {
        roundResult.ball > 0 && roundResult.strike == 0 -> "${roundResult.ball}볼"
        roundResult.strike > 0 && roundResult.ball == 0 -> "${roundResult.strike}스트라이크"
        roundResult.ball > 0 && roundResult.strike > 0 -> "${roundResult.ball}볼 ${roundResult.strike}스트라이크"
        else -> "낫싱"
    }
    println(hint)
    if(roundResult.strike == 3) println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

/* 라운드 조건 검사 결과 출력 function : printHint*/
fun askRetry(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val retryAnswer = readLine()
    return when (retryAnswer) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException("잘못된 입력입니다, 올바른 숫자가 아닙니다.")
    }
}
