package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자야구 게임을 시작합니다.")
    var play = true
    while (play)
    {
        baseballgame()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val checkgame = readLine()
        if (checkgame != null)
        {
            val checkgamenum = checkgame.toInt()
            play = when (checkgamenum) {
                1 -> {
                    true
                }
                2 -> {
                    false
                }
                else -> {
                    throw IllegalArgumentException("잘못된 값을 입력하였습니다.")
                }
            }
        } else {
            println("입력값이 비어있습니다.")
        }
    }
}
fun baseballgame() {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    while (true) {
        var str = 0 // 스트라이크
        var ball = 0 // 볼
        print("숫자를 입력해주세요 : ")
        val input = readLine() // 숫자 입력 받기
        if (input != null && input.length == 3) {
            try {
                val firstnum = input[0].toString()
                val secondnum = input[1].toString()
                val thirdnum = input[2].toString()
                val numList = mutableListOf<Int>()
                numList.add(firstnum.toInt()) // 숫자로 만들어서 예외체크
                numList.add(secondnum.toInt())
                numList.add(thirdnum.toInt())
                if (numList.distinct().size != 3)
                {
                    throw IllegalArgumentException("서로다른 3자리 숫자를 입력해주세요.")
                }

                for (i in 0..2)
                {
                    if (numList[i] == computer[i])
                    {
                        str += 1
                    } else if (numList[i] in computer)
                    {
                        ball += 1
                    }
                }
                if (str == 0 && ball == 0) // 스트라이크와 볼 둘다 0인경우
                {
                    println("낫싱")
                } else if (ball == 0) // 스트라이크만 존재하는 경우
                {
                    println("${str}스트라이크")
                    if (str == 3){
                        // 3스트라이크인 경우
                        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        break
                    }
                } else if (str == 0) // 볼만 존재하는 경우
                {
                    println("${ball}볼")
                } else // 볼과 스트라이크가 전부 존재하는 경우
                {
                    println("${ball}볼 ${str}스트라이크")
                }

            } catch (e: IllegalArgumentException) {
                throw IllegalArgumentException("입력값은 숫자가 아닙니다.")
            }
        } else {
            throw IllegalArgumentException("입력값이 비어있거나 3자리 숫자가 아닙니다.")
        }
    }
}