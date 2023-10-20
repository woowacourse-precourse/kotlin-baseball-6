package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    var finish = false
    //난수 생성
    var temp = ""
    var randomNumList = mutableListOf<String>()
    while (randomNumList.size < 3) {
        temp = Randoms.pickNumberInRange(1, 9).toString()
        if (!randomNumList.contains(temp)) {
            randomNumList.add(temp)
        }
    }
    while (!finish) {
        print("숫자를 입력해주세요 : ")
        val userInput = Console.readLine() //플레이어 입력

        val regex = "[1-9]{3}".toRegex() //1-9사이의 숫자로 구성된 세 자릿수 정규표현식

        //regex와 일치하면서 set을 이용해 중복된 수가 있는지 확인
        if (regex.matches(userInput) && (userInput.length == userInput.toSet().size)) {
            val userInputList: List<String> = userInput.chunked(1)
            //난수와 사용자 입력 비교
            var strike = 0
            var ball = 0
            var nothing = 0

            for (i in userInputList.indices) {
                if (userInputList[i] == randomNumList[i]) {
                    //각 자릿 수 모두 일치
                    strike++
                } else if ((userInputList[i] != randomNumList[i]) && randomNumList.contains(userInputList[i])) {
                    //같은 숫자가 다른 자리에 존재
                    ball++
                }
            }
            if (ball == 0 && strike == 0) {
                nothing = 1
            }

            if (strike == 3) {
                println("3스트라이크")
                print("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

            } else if (nothing == 1) {
                println("낫싱")
            } else {
                if (strike == 0) {
                    println("${ball}볼")
                } else if (ball == 0) {
                    println("${strike}스트라이크")
                } else {
                    println("${ball}볼 ${strike}스트라이크")
                }
            }

        } else {
            throw IllegalArgumentException("It is not a triple digit composed of different numbers between 1 and 9 :$userInput")
        }

    }


}
