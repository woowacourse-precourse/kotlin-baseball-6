package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    println("숫자 야구 게임을 시작합니다.")

    var numString:String
    var nums:MutableList<Int>
    var strike:Int = 0
    var ball:Int = 0
    var again = 1

    var answers:MutableList<Int>

    while(again == 1){
        strike=0
        ball=0
        answers = mutableListOf()
        while (answers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answers.contains(randomNumber)) {
                answers.add(randomNumber)
            }
        }
        while(strike != 3){
            strike=0
            ball=0

            print("숫자를 입력해주세요 : ")
            numString = Console.readLine()
            nums = numString.map{it.toString().toInt()}.toMutableList()

            for(i in 0..2){
                if(nums[i] in answers && nums[i]==answers[i]){
                    strike += 1
                }else if (nums[i] in answers && nums[i]!=answers[i]){
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
        try{
            again = Console.readLine().toInt()
            if(again == 2){
                println("게임 종료")
            }
        }catch (e:IllegalArgumentException){
            throw e
        }
    }



}
