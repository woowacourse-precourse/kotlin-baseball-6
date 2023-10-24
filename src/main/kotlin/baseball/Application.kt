package baseball

import camp.nextstep.edu.missionutils.*

fun gameStart(): Int { // 회차별 게임 진행
    val computer = generate_cnt()

    while (true) {
        print("숫자를 입력해주세요 : ")
        var inputNum: Int

        inputNum = readLine()!!.toInt()
        val user = divide_num(inputNum)

        if (user.size == 0) return 3

        println(inputNum)

        val ballCnt = ball(user, computer)
        val strikeCnt = strike(user, computer)

        if (ballCnt == 0 && strikeCnt == 0) {
            print("낫싱")
        }

        if (ballCnt != 0) {
            print("$ballCnt" + "볼 ")
        }

        if (strikeCnt != 0) {
            print("$strikeCnt" + "스트라이크")
        }

        println()

        if (strikeCnt == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            return readLine()!!.toInt()
        }
    }
}

fun divide_num(num: Int): MutableList<Int> { // 입력받은 숫자 분할
    val user = mutableListOf<Int>()

    if (num !in 100..999) {
        throw IllegalArgumentException("잘못된 입력입니다.")
        return user
    }

    user.add(num/100)
    user.add(num%100/10)
    user.add(num%10)

    val checkList: List<Int> = user.distinct()

    if (checkList.size != 3) {
        throw IllegalArgumentException("잘못된 입력입니다.")
        return mutableListOf<Int>()
    }

    return user
}

fun generate_cnt(): MutableList<Int> { // 정답 카운트 생성
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber))
            computer.add(randomNumber)
    }

    return computer
}

fun ball(user: MutableList<Int>, computer: MutableList<Int>): Int { // 볼 카운트 계산
    var ballCnt = 0
    var cnt = 0

    while (cnt < 3) {
        if (computer.contains(user[cnt]) && computer[cnt] != user[cnt]){
            ballCnt++
        }
        cnt++
    }

    return ballCnt
}

fun strike(user: MutableList<Int>, computer: MutableList<Int>): Int { // 스트라이크 카운트 계산
    var strikeCnt = 0
    var cnt = 0

    while (cnt < 3) {
        if (computer[cnt] == user[cnt]){
            strikeCnt++
        }
        cnt++
    }

    return strikeCnt
}

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (true) {
        val cmdNum: Int = gameStart()

        if (cmdNum == 1){
            println(cmdNum)
            continue
        }
        else if (cmdNum == 2) {
            println(cmdNum)
            break
        }
        else{
            throw IllegalArgumentException("잘못된 입력입니다.")
            break
        }

    }

}
