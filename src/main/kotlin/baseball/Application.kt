package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var userNums:MutableList<Int>
    var strike:Int
    var ball:Int
    var again = 1

    var randomNums:MutableList<Int>

    while(again == 1){
        strike=0
        ball=0
        randomNums = getRandomNums()

        while(strike != 3){
            strike=0
            ball=0

            print("숫자를 입력해주세요 : ")

            userNums = getUserNums()

            for(i in 0..2){
                if(userNums[i] in randomNums && userNums[i]==randomNums[i]){
                    strike += 1
                }else if (userNums[i] in randomNums && userNums[i]!=randomNums[i]){
                    ball += 1
                }
            }

            if(strike != 0 && ball ==0){
                println("${strike}스트라이크")
            }else if(strike ==0 && ball !=0){
                println("${ball}볼")
            }else if (strike !=0 && ball !=0){
                println("${ball}볼 ${strike}스트라이크")
            }else{
                println("낫싱")
            }
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        again = Console.readLine().toInt()
    }
}

fun getRandomNums():MutableList<Int>{
    var randomNums = mutableListOf<Int>()
    while (randomNums.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!randomNums.contains(randomNumber)) {
            randomNums.add(randomNumber)
        }
    }
    return randomNums
}

fun getUserNums():MutableList<Int>{
    var nums = Console.readLine().map{it.toString().toInt()}.toMutableList()
    if(nums.size != 3){
        throw IllegalArgumentException()
    }
    return nums
}



