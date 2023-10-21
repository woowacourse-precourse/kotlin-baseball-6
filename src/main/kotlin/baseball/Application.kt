package baseball

import camp.nextstep.edu.missionutils.Randoms

fun makeRandomNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun printResult(ball: Int, strike : Int){
    if(ball==0){
        if(strike==0){
            print("낫싱\n")
        }else{
            print("$strike"+"스트라이크\n")
        }
    }else{
        if(strike==0){
            print("$ball"+"볼\n")
        }else{
            print("$ball"+"볼 "+"$strike"+"스트라이크\n")
        }
    }
}

fun main() {
    var play = true
    print("숫자 야구 게임을 시작합니다.\n")

    while (play) {
        val computer = makeRandomNumber()

        while (true) {
            print("숫자를 입력해주세요 : ")
            val userInput = readLine()

            if (userInput != null && userInput.matches(Regex("^[0-9]*$"))) {
                val userInputList = userInput.map { it.toString().toInt() }

                if (userInputList.size != 3 || userInputList.distinct().size != 3) {
                    throw IllegalArgumentException("서로 다른 3자리 숫자를 입력해야 합니다.")
                }

                var ball = 0
                var strike = 0

                for (num in userInputList) {
                    if (num in computer) {
                        val computerNum = computer.indexOf(num)
                        val myNum = userInputList.indexOf(num)
                        if (myNum == computerNum) {
                            strike += 1
                        } else {
                            ball += 1
                        }
                    }
                }

                printResult(ball, strike)

                if (strike == 3) {
                    print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n")
                    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n")
                    val tryagain = readLine()
                    if (tryagain == "2") {
                        play = false
                    }
                    break
                }
            } else {
                throw IllegalArgumentException("숫자 이외의 문자가 입력되었습니다.")
            }
        }
    }
}
