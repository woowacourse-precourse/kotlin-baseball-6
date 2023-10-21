package baseball

import camp.nextstep.edu.missionutils.Randoms

/*
기능명세
컴퓨터 : 랜덤 수 3개를 뽑는다 - 사용자가 맞추기 전까지 바뀌지 않음

게임(숫자를 비교한다) :
1/ 3자리수를 다 맞춘경우
    1,2를 입력해서 재시작/종료를 구분
2/ 3자리수를 다 맞추지 못한 경우
    1. 스트라이크 - 같은 자리에 있으면
    2. 볼    - 다른 자리에 있으면
    3. 낫싱인경우    - 같은 수가 전혀 없으면

사람 : 0~9까지의 숫자 중에서 3개를 입력받는다

 */
fun main() {


}
class User(){
    /*
    입력한 값이 이상한 경우
    자릿수가 3개가 아닌경우, 0~9가 아닌경우, 숫자가 아닌경, 중복된 숫자가 들어가있는 경우
     */
}


class BaseBall(val userNum: MutableList<Int>, val gameNum: MutableList<Int>) {  //입력한 값을 파라미터로 받는다
    var strike = 0
    var ball = 0


    private fun checkStrike() {
        for (i in 0..userNum.size) {
            if (userNum[i] == gameNum[i]) {
                strike++
            }
        }
    }

    private fun checkBall() {
        for (i in 0..userNum.size) {
            for (game in 0..gameNum.size) {
                if (userNum[i] == gameNum[game]) {
                    ball++
                }
            }
        }
    }


    private fun printBallNum() {
        if (ball == 0 && strike > 0) {
            println("{$strike}스트라이크")
        } else if (ball > 0 && strike == 0) {
            println("{$ball}볼")
        } else if (ball > 0 && strike > 0) {
            println("{$ball}볼 {$strike}스트라이크")
        } else {
            println("낫싱")
        }
    }

    companion object {
        const val COMPLETE = "COMPLETE"
        const val CONTINUE = "CONTINUE"
    }
}

