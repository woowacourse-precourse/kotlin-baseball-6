package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console.readLine

const val SIZE = 3 // 리스트의 길이
var strikes = 0 // 스트라이크 개수
var balls = 0 // 볼 개수
var keepPlaying = 0 // 게임을 계속할지 결정하는 변수

// 메서드 : startGame() -> 예외처리(), 게임()
fun main() {
    startGame()
}

fun startGame() {
    val computerNumbers = mutableListOf<String>() // 컴퓨터가 생성한 숫자 리스트
    val userNumbers = mutableListOf<String>() // 사용자가 입력한 숫자 리스트

    println("숫자 야구 게임을 시작합니다.")

    do {
        strikes = 0 // 스트라이크 개수 초기화
        computerNumbers.clear() // 컴퓨터가 생성한 숫자 리스트 초기화

        while (computerNumbers.size < SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9).toString() // 랜덤 수 생성
            if (!computerNumbers.contains(randomNumber)) { // 서로 다른 수를 리스트에 저장
                computerNumbers.add(randomNumber)
            }
        }
        while (strikes != SIZE) { // 모두 맞출 때까지 반복
            strikes = 0 // 스트라이크 개수 초기화
            balls = 0 // 볼 개수 초기화
            userNumbers.clear() // 사용자가 입력한 숫자 리스트 초기화
            print("숫자를 입력해주세요 : ")

            val userNumber = readLine() // 사용자에게 입력 받기

            // 예외 처리
            handleInput(userNumber, userNumbers)
            // 숫자 비교
            compareNumbers(computerNumbers, userNumbers)

        }
    } while (keepPlaying == 1) // 사용자가 1을 입력한 경우 게임 계속

    println("게임 종료")
}

fun handleInput(userNumber: String, userNumbers: MutableList<String>) {
    if (userNumber.length != SIZE) { // 입력 값의 길이가 SIZE가 아닌 경우
        throw IllegalArgumentException("입력값이 3자리 숫자가 아닙니다.")
    }
    for (i in 0 until SIZE) {
        if (userNumber[i] < '1' || userNumber[i] > '9') { // 입력 값이 1과 9사이의 숫자가 아닌 경우
            throw IllegalArgumentException("모든 입력값은 0부터 9까지의 숫자여야 합니다.")
        }
    }
    for (i in 0 until SIZE) {
        userNumbers.add(userNumber[i].toString()) // 입력 값 리스트에 저장
        if (userNumbers.count { it == userNumber[i].toString() } > 1) { // 중복된 값이 있는 경우
            throw IllegalArgumentException("3개의 숫자는 서로 달라야 합니다.")
        }
    }
}

fun compareNumbers(computerNumbers: MutableList<String>, userNumbers: MutableList<String>) {
    for (i in 0 until SIZE) {
        for (j in 0 until SIZE) {
            if (computerNumbers[i] == userNumbers[j]) { // 컴퓨터가 생성한 값과 사용자가 입력한 값이 같을 때
                if (i == j) { // 인덱스(위치)도 같다면
                    strikes++ // 스트라이크
                } else { // 인덱스는 다르다면
                    balls++ // 볼
                }
            }
        }
    }
    if (balls == 0 && strikes == 0) { // 같은 값이 없다면
        println("낫싱") // 낫싱
    } else if (balls > 0 && strikes > 0) { // 볼과 스트라이크가 모두 있다면
        println("${balls}볼 ${strikes}스트라이크")
    } else if (strikes > 0) { // 스트라이크만 있다면
        println("${strikes}스트라이크")
        if (strikes == SIZE) { // 모두 맞춘 경우
            println("${SIZE}개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            keepPlaying = readLine()?.toIntOrNull() ?: 0 // 게임 계속할지 말지 입력 받기
        }
    } else if (balls > 0) { // 볼만 있다면
        println("${balls}볼")
    }
}