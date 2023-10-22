package baseballgame

import constant.Constant
import constant.StringError
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

class Game {
    private val comNumber = mutableListOf<Int>()// 컴퓨터 난수 저장

    init {
        while (comNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber)
            }
        }
        println(comNumber) // 중간 확인용
    }

    private fun restart(): Boolean {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
        val select = Console.readLine()
        return when (select) {
            "1" -> {
                true
            }

            "2" -> {
                false
            }

            else -> {
                println("오류 발생")
                false
            }
        }
    }

    companion object{
        fun run() {
            do {
                val game = Game()
                game.userEnter()
            } while (game.restart())
        }
    }

    private fun userEnter() {
        do{
            print("숫자를 입력해주세요: ")
            val userNumber = Console.readLine()
            println(userNumber)
        } while (!checkStrike(userNumber)) // 3스트라이크가 나올때까지
    }

    private fun checkStrike(input: String): Boolean {
        val inputArray = changeStringToIntArray(input)
        val strike = countStrike(inputArray)
        var ball = countBall(inputArray)

        if(strike == 3) {
            return true
        } else {
            return false
        }
    }

    private fun countStrike(inputNumber: IntArray): Int {
        var strike = 0
        for (i in inputNumber.indices) {
            if (inputNumber[i] == comNumber[i]) {
                strike++
            }
        }
        return strike
    }

    private fun countBall(inputNumber: IntArray): Int {
        var ball = 0
        for (i in inputNumber.indices) {
            if (comNumber.contains(inputNumber[i])) {
                ball++
            }
        }
        return ball
    }

    // 사용자에게 입력받은 문자열을 정수 배열로 변환
    private fun changeStringToIntArray(inputString: String): IntArray {
        val stringArray: Array<String> = inputString.toCharArray().map { it.toString() }.toTypedArray()
        // string 길이가 3인지 확인해야함
        val intArray = IntArray(3)
        stringArray.indices.forEach{ intArray[it] = stringArray[it].toInt()}
        return intArray
    }

    /*fun computeStrikeBall(comNumber: List<Int>, userNumber: List<Int>):Boolean{
        var strike = 0
        var ball = 0
        for(i in 0..2){
            if(userNumber[i] == comNumber[i]){
                strike++
            }
            else if(userNumber[i] in comNumber){
                ball++
            }
        }
        when{
            strike == 3 -> {
                println("3스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 죵료")
                return true
            }

            strike == 0 && ball == 0 -> println("낫싱!")
            ball == 0 -> println("${strike}스트라이크")
            strike == 0 -> println("${ball}볼")
            else -> println("${ball}볼 ${strike}스트라이크 ")
        }
        return false
    }*/
    /*fun baseball() {
        val comNumber = run()
        println(comNumber)
        var flag = false

        while (!flag) {
            try{
                print("숫자를 입력해주세요: ")
                val input = readLine() ?: ""
                val userNumber = input.map{it.toString().toInt() }
                print(userNumber)
                if (userNumber.size != 3 || userNumber.any {it < 1 || it > 9}){
                    throw IllegalArgumentException("오류 발생")
                }
                if (computeStrikeBall(comNumber, userNumber)){
                    flag = true
                }
            } catch (e: IllegalArgumentException){
                println(e.message)
                return
            }
        }

    }*/
}