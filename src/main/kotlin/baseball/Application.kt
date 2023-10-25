package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException
import java.util.Scanner

fun main() {

    var regame = 1 // 1:다시시작, 2:게임종료
    while(regame == 1){
        var arr: Array<Int> = Array(10) {0}
        var three_num_arr: Array<Int> = Array(3) {0}

        var cnt = 0;
        while(true){
            if(cnt == 3){
                break
            }

            val k = Randoms.pickNumberInRange(1, 9)
            if(arr[k] == 0){
                arr[k] = 1
                three_num_arr[cnt] = k
                cnt++
            }
        }

        println("숫자 야구 게임을 시작합니다.")

        while(true){
            print("숫자를 입력해주세요: ")
            val guess_num = readLine()!!.toInt()

            var guess_num_arr: Array<Int> = Array(3) {0}
            guess_num_arr[0] = guess_num / 100
            guess_num_arr[1] = (guess_num % 100) / 10
            guess_num_arr[2] = guess_num % 10

            if(guess_num in 123..987
                && guess_num_arr[0] != guess_num_arr[1]
                && guess_num_arr[1] != guess_num_arr[2]
                && guess_num_arr[2] != guess_num_arr[0]
                && guess_num_arr[0] != 0
                && guess_num_arr[1] != 0
                && guess_num_arr[2] != 0){
                guess_num
            }else{
                throw IllegalArgumentException("잘못된 입력입니다. 게임종료")
                return
            }

            var strike = 0
            var ball = 0

            for(i: Int in 0..2){ // guess_num_arr
                for(j: Int in 0..2){ // three_num_arr
                    if(guess_num_arr[i] == three_num_arr[j]){
                        if(i == j){
                            strike++
                        }else{
                            ball++
                        }
                    }
                }
            }

            if(strike == 3){
                println("3스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                regame = readLine()!!.toInt()
                if(regame == 2){
                    println("게임 종료")
                    return
                }
                break
            }else if(strike == 0 && ball == 0){
                println("낫싱")
            }else if(strike == 0 && ball == 1){
                println("1볼")
            }else if(strike == 0 && ball == 2){
                println("2볼")
            }else if(strike == 0 && ball == 3){
                println("3볼")
            }else if(strike == 1 && ball == 0){
                println("1스트라이크")
            }else if(strike == 1 && ball == 1){
                println("1볼 1스트라이크")
            }else if(strike == 1 && ball == 2){
                println("2볼 1스트라이크")
            }else if(strike == 2 && ball == 0){
                println("2스트라이크")
            }


        }
    }



}
