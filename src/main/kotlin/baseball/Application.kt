package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main(){
    printStart()
    baseball()
}
/* 플레이어의 라운드 기록 데이터 구조체 Round */
data class Round(var strike: Int = 0, var ball: Int = 0)

/* 숫자 야구 시작 메세지 function : printStart */
fun printStart(){
    println("숫자 야구 게임을 시작합니다.")
}

/* 숫자 야구 진행 function : baseball */
fun baseball(){
    while(true){
        val computer = getComputerNumber() //Computer 랜덤 수 생성
        while(true){
            val player = getPlayerNumber() //Player 숫자 입력
            val roundResult: Round = compareList(computer, player) //Computer와 Player 숫자 비교
            printHint(roundResult) //힌트 출력
            if(roundResult.strike == 3) break //baseball 종료
        }
        if(!(askRetry())) break //재도전 여부 입력 요청
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
fun getPlayerNumber(): List<Int>{
    val player = mutableListOf<Int>()
    print("숫자를 입력해주세요 : ")
    val testNumber = Console.readLine()
    val verifiedNumber = checkNumber(testNumber)
    for (char in verifiedNumber) {
        val digit = char.toString().toInt()
        player.add(digit)
    }
    return player
}

/* 플레이어가 잘못된 값을 입력한 경우(예외처리) function : CheckNumber */
fun checkNumber(testNumber: String?): String{
    if (testNumber.isNullOrBlank()) { //공백이거나 아무것도 입력하지 않은 경우
        throw IllegalArgumentException("잘못된 입력입니다, 공백입니다.")
    }
    testNumber.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력입니다, 올바른 숫자가 아닙니다.") //숫자가 아닌 것을 입력한 경우
    if (testNumber.length < 3 || testNumber.length > 3) { //3자리 미만 혹은 3자리를 초과한 숫자를 입력한 경우
        throw IllegalArgumentException("잘못된 입력입니다, 숫자는 3자리이여야 합니다.")
    }
    for (char in testNumber) {
        val digit = char.toString().toIntOrNull()
        if (digit == null || digit < 1 || digit > 9) { //1~9범위를 벗어난 숫자를 입력한 경우
            throw IllegalArgumentException("잘못된 입력입니다, 올바른 범위의 숫자가 아닙니다.")
        }
    }
    val uniqueDigits = testNumber.toSet()
    if (uniqueDigits.size != testNumber.length) { //중복된 숫자를 입력한 경우
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

/* 재시작(1)/종료(2) 플레이어(Player) 입력 요청 function : askRetry*/
fun askRetry(): Boolean{
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val retryAnswer = Console.readLine()
    return when (retryAnswer) {
        "1" -> true
        "2" -> false
        else -> throw IllegalArgumentException("잘못된 입력입니다, 올바른 숫자가 아닙니다.")
    }
}
