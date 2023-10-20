package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

fun main() {

    println("숫자 야구 게임을 시작합니다.")
    while(true){
        //var computer_number = Randoms.pickUniqueNumbersInRange(1,9,3)
        var computer_number = arrayOf(1,2,3)

        var sum = 0;
        for(item in computer_number){
            sum += item
            sum *= 10
        }
        sum /= 10

        while(true){
            print("숫자를 입력해주세요 : ")
            var scan : Int = Console.readLine().toInt()

            if(scan > 999 || scan < 100){
                if(scan < 0){
                    println("양수를 입력해주세요")
                    continue
                }
                println("세자리의 숫자만 입력해주세요")
                continue
            }

            if(scan != sum){
                println("틀렸습니다.")
            }else{
                println("정답입니다.")
                break;
            }
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var scan : Int = Console.readLine().toInt()

        if(scan != 1){
            break;
        }
    }


}
