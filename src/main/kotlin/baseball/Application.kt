package baseball

import camp.nextstep.edu.missionutils.Randoms

class RandomNumber{
    var RandomNumber = 123

    constructor() {
        RandomNumber = Randoms.pickNumberInRange(123, 987)
    }

}
class UserNumber {
    var InputNumber = 123

    constructor(Input: String){
        InputNumber = Input.toInt() // Need Refactor
    }

}

fun main() {
    var InputNum = "123" // Need Refactor

    InputNum = readLine().toString() // Need Refactor

}

/*
* 추가할 부분
* 1. 같은 숫자 (ex. 111, 998, 997 등등) 에 대해서 예외 처리
*
* */
