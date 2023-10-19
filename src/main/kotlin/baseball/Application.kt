package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import sun.jvm.hotspot.runtime.DeadlockDetector.print
import java.sql.DriverManager.println

fun main() {

    var ran1: Int = Randoms.pickNumberInRange(1, 9)
    var ran2: Int = Randoms.pickNumberInRange(1, 9)
    var ran3: Int = Randoms.pickNumberInRange(1, 9)

    var ans: Int = 100 * ran1 + 10 * ran2 + ran3

    //컴퓨터가 3자리 수를 생성한다.




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

    fun numStrike(a:IntArray, b:IntArray):Int{
        var strikeNum: Int =0
        for (i in 0..2){
            if(a[i]==b[i]){
                strikeNum=strikeNum+1
            }
        }
        return strikeNum
    }

    println("숫자 야구 게임을 시작합니다.")

    while (user !=ans){

        var ball:Int = numBall()
        var strike:Int = numStrike()
        var user: Int = 0
        var ifCon:Int

        user = readLine().toInt()

        if (ball>0){
            print("$ball")
            print("볼 ")
        }

        if (strike>0){
            print("$strike")
            print("스트라이크")
        }

        print("\n")

        if (ball==0 && strike==0){
            println("낫싱")
        }

        if (ans==user){
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            ifCon = readLine().toInt()

        }




    }
}


