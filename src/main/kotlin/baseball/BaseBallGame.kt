package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class BaseBallGame() {
    private val answer = RandomNumberGenerator.generateRandomNumber()
    init {
        startGame()

        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
    private fun startGame(){
        do {
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine()
            if (!checkInput(input)){
                throw IllegalArgumentException("")
            }

        }
        while (!isAnswer(input))
    }
    private fun checkInput(input : String) : Boolean{

        fun hasDuplicateCharacters(input: String): Boolean {
            val charSet = mutableSetOf<Char>()

            for (char in input) {
                if (charSet.contains(char)) {
                    return true
                }
                charSet.add(char)
            }
            return false
        }

        //숫자 확인
        try {
            input.toInt()
        } catch (e : NumberFormatException){
            return false
        }

        //길이 및 중복 숫자 확인
        return input.length == 3 && !hasDuplicateCharacters(input)
    }


    private fun isAnswer(input : String): Boolean {
        val inputSet = input.toSet()

        return if (answer == input) {
            true
        } else {
            var strikeCount = 0
            var ballCount = 0

            answer.forEachIndexed { index, it ->
                if (inputSet.contains(it)){
                    if (index == input.indexOf(it)){
                        strikeCount++
                    } else {
                        ballCount++
                    }
                }
            }
            if (ballCount + strikeCount > 0){
                if (ballCount != 0){
                    print(ballCount.toString() + "볼 ")
                }
                if (strikeCount != 0){
                    print(strikeCount.toString() + "스트라이크")
                }
            } else {
                print("낫싱")
            }
            println()

            false
        }
    }




}