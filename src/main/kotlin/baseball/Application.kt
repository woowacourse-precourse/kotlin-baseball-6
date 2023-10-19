package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    var ran1: Int = Randoms.pickNumberInRange(1, 9)
    var ran2: Int = Randoms.pickNumberInRange(1, 9)
    var ran3: Int = Randoms.pickNumberInRange(1, 9)

    var ans: Int = 100 * ran1 + 10 * ran2 + ran3

    //컴퓨터가 3자리 수를 생성한다.

    var user: Int = 0


    fun numBall(a:IntArray, b:IntArray): Int {
        var ballNum: Int =0
        for(i in 0..2){
            if(a[i] in b){
                if(a[i]!=b[i]){
                    ballNum=ballNum+1
                }
            }
        }

        return ballNum
    }

    fun ifStrike(){

    }


    while (user !=ans){
        user = readLine().toInt()



    }
}


