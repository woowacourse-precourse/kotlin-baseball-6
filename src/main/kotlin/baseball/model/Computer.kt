package baseball.model


import camp.nextstep.edu.missionutils.Randoms

object Computer {
    //컴퓨터 난수 생성, 저장
    fun pickNumbers(): MutableList<Int> {

        val computer = mutableListOf<Int>()
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }
    // 사용자 / 컴퓨터 정답 비교
    fun baseball(user: MutableList<Int>, computer : MutableList<Int>) :  Pair<Int, Int>{

        var strikes : Int = 0
        var balls : Int = 0
        for (i in 0..2) {
            if (user[i] == computer[i]) {
                strikes++
            }
            else if (user[i] in computer.filterIndexed { index, _ -> index != i }) {
                balls++
            }
        }
        return Pair(strikes, balls)
    }
}