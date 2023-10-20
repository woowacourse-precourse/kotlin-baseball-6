package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    //난수 생성
    var temp = ""
    val randomNumList = mutableListOf<String>()
    while (randomNumList.size < 3) {
        temp = Randoms.pickNumberInRange(1, 9).toString()
        if (!randomNumList.contains(temp)) {
            randomNumList.add(temp)
        }
    }

    print("숫자를 입력해주세요 : ")
    val userInput = Console.readLine() //플레이어 입력

    val regex = "[1-9]{3}".toRegex() //1-9사이의 숫자로 구성된 세 자릿수 정규표현식

    //regex와 일치하면서 set을 이용해 중복된 수가 있는지 확인
    if (regex.matches(userInput) && (userInput.length == userInput.toSet().size)) {
        val userInputList:List<String> = userInput.chunked(1)
        //난수와 사용자 입력 비교
    } else {
        throw IllegalArgumentException("It is not a triple digit composed of different numbers between 1 and 9 :$userInput")
    }




}
