package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printStart()
    baseball()
}
/* 플레이어의 라운드 기록 구조체 Round */
data class Round(val strike: Int = 0, val ball: Int = 0)

/* 숫자 야구 시작 선언 Function : printStart */
fun printStart(){
    println("숫자 야구 게임을 시작합니다.")
}

/* 숫자 야구 진행 Function : baseball */
fun baseball(){
    while(true){
        val computer = getComputerNumber()
        while(true){
            val player = getPlayerNumber()
            //val roundResult: Round = compareNumber(computer, player)
            //printHint(roundResult)
            //if(roundResult.strike==3) break
        }
        //if(!(askRetry())) break

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
    // testNumber가 null이거나 공백인 경우
    if (testNumber.isNullOrBlank()) {
        throw IllegalArgumentException("잘못된 입력입니다, 공백입니다.")
    }
    //testNumber가 숫자로 이루어지지 않은 경우
    val testNumberInt = testNumber.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력입니다, 올바른 숫자가 아닙니다.")
    // testNumber의 길이가 3자리 미만이거나 3자리를 초과한 경우
    if (testNumber.length < 3 || testNumber.length > 3) {
        throw IllegalArgumentException("잘못된 입력입니다, 숫자는 3자리이여야 합니다.")
    }
    //testNumber의 각 자리 숫자가 1부터 9 범위를 벗어나지 않는지 검사
    for (char in testNumber) {
        val digit = char.toString().toIntOrNull()
        if (digit == null || digit < 1 || digit > 9) {
            throw IllegalArgumentException("잘못된 입력입니다, 올바른 범위의 숫자가 아닙니다.")
        }
    }
    //testNumber에서 중복된 숫자가 존재하는지 검사
    val uniqueDigits = testNumber.toSet()
    if (uniqueDigits.size != testNumber.length) {
        throw IllegalArgumentException("잘못된 입력입니다, 중복된 숫자가 존재합니다.")
    }

    return testNumber
}


/*
fun compareNumber(computer: List<Int>, player: List<Int>): Round{

}

fun printHint(roundResult: Round){

}
fun askRetry(): Boolean{

}
 */






