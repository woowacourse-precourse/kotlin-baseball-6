package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    TODO("프로그램 구현")
}

//랜덤 숫자 생성
fun makeRandomNumber(): String { 
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
        computerNumber.add(randomNumber)
        }
    }
    return computerNumber.joinToString("")
}

 //사용자로부터 숫자를 입력받기
 fun getUserNumber(): String {
    print("숫자를 입력해주세요: ")
    val userInputNumber = Console.readline().toString()
    val userNumber = mutableListOf<Char>()
    
    if (userInputNumber.length != 3) { //예외처리
        throw IllegalArgumentException("숫자를 ${'"'}3개${'"'} 입력해야 합니다.")
    }

    for (char in userInputNumber) { // 입력받은 값을 userNumber에 저장
        userNumber.add(char)
    }

    return userNumber.joinToString("")
}

// 스트라이크와 볼 갯수를 카운트하고 힌트 출력
fun countStrikeAndBallAndPrintHint(answer: String, userNumber: String) {
    var strike = 0
    var ball = 0

    for (index in userNumber.indices) {
        if (userNumber[index] == answer[index]) {
            strike++
        } else if (answer.contains(userNumber[index])) {
            ball++
        }
    }

    if (strike == 0 && ball == 0) {
        println("낫싱")
    } else if (strike == 0) {
        println("${ball}볼")
    } else if (ball == 0) {
        println("${strike}스트라이크")
    } else {
        println("${ball}볼 ${strike}스트라이크")
    }
}

//게임 시작 문구 출력
fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

//게임 종료 문구 출력
fun printGameOVerMessage() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

//게임 다시할건지 물어보기
fun askToRestartGame() {
    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}
