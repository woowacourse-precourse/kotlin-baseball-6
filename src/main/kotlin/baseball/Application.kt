package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

fun check(str_num : String): Boolean{
    for(item in str_num) {
        var cnt = 0
        for(item_2 in str_num){
            if(item == item_2)
                cnt++;
        }
        if(cnt > 1)
            return true
    }
    return false
}

fun main() {

    println("숫자 야구 게임을 시작합니다.")
    while(true){
        var rand = Randoms.pickUniqueNumbersInRange(1,9,3)

        var sum = 0;
        for(item in rand){
            sum += item
            sum *= 10
        }
        sum /= 10

        var rand_num = sum.toString()

        while(true){
            var flag = false
            print("숫자를 입력해주세요 : ")
            var str_num = Console.readLine()
            if(str_num.toInt() > 999 || str_num.toInt() < 100 || check(str_num)){
                throw IllegalArgumentException("입력 오류")
            }
            while(true) {

                var strike = 0
                var ball = 0

                if (!str_num.equals(rand_num)) {
                    for(item in str_num) {
                        if (rand_num.indexOf(item) == str_num.indexOf(item)) { //인덱스 값이 같을 때 스트라이크 1 증가
                            strike++
                        } else {
                            if (rand_num.contains(item)) {//인덱스 값이 다르나 랜덤 수에 값이 존재 시 볼 1 증가
                                ball++
                            }
                        }
                    }
                    if(strike == 0 && ball == 0){
                        println("낫싱")
                    }else{
                        if(ball > 0){
                            print("${ball}볼 ")
                        }
                        if(strike > 0){
                            print("${strike}스트라이크")
                        }
                        println()
                    }

                    print("숫자를 입력해주세요 : ")
                    str_num = Console.readLine()
                    if(str_num.toInt() > 999 || str_num.toInt() < 100 || check(str_num)){
                        throw IllegalArgumentException("입력 오류")
                    }

                } else {
                    println("정답입니다.")
                    flag = true
                    break
                }
            }
            if(flag)
                break
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var scan : Int = Console.readLine().toInt()
        if(scan == 1)
        else if(scan == 2)
            break
        else
            throw IllegalArgumentException("입력 오류")
    }


}
