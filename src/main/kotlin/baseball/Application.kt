package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

import kotlin.IllegalArgumentException

fun main() {

    var guess: List<Int>
    println("숫자 야구 게임을 시작합니다.")
    do {

        // 무작위 세자리 수 생성
        val numberToGuess = mutableListOf<Int>()
        while (numberToGuess.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!numberToGuess.contains(randomNumber)) {
                numberToGuess.add(randomNumber)
            }
        }

        do {
            println("세 자리의 숫자를 입력하세요:")
            guess = Console.readLine()!!.chunked(1).map { it.toInt() } //사용자로부터 3자리수의 숫자 입력 받기
            if (guess.contains(0) || guess.distinct().size != guess.size || guess.size != numberToGuess.size){
                throw IllegalArgumentException()
            }

            val strike = numberToGuess.zip(guess).count { it.first == it.second }
            val balls = guess.intersect(numberToGuess).count() - strike

            if(balls == 0 && strike != 0){
                println("${strike}스트라이크")
            } else if(strike == 0 && balls != 0){
                println("${balls}볼")
            } else if(balls == 0 && strike == 0){
                println("낫싱")
            } else{
                println("${balls}볼 ${strike}스트라이크")
            }
        } while (guess != numberToGuess)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        var choice: String
        choice = Console.readLine()!!
        if (choice != "1" && choice != "2"){
            throw IllegalArgumentException("잘못된 입력입니다. 프로그램을 종료합니다.")
        }
    }while (choice == "1")
}