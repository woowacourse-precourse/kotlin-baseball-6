package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import sun.jvm.hotspot.runtime.DeadlockDetector.print
import java.sql.DriverManager.println

fun main() {


    fun makeNum():IntArray {
        var ans = IntArray(3)
        var ran1: Int
        var ran2: Int
        var ran3: Int

        ran1 = Randoms.pickNumberInRange(1, 9)
        ans[0]=ran1

        do{ ran2 = Randoms.pickNumberInRange(1, 9)
        } while(ran2==ran1)
        ans[1]=ran2

        do{ ran3 = Randoms.pickNumberInRange(1, 9)
        }while(ran3==ran2 || ran3==ran1)
        ans[2]=ran3

        return ans

    } //서로 다른 3자리의 수를 가진 배열 생성

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
    } // 볼의 개수를 알려주는 함수

    fun numStrike(a:IntArray, b:IntArray):Int{
        var strikeNum: Int =0
        for (i in 0..2){
            if(a[i]==b[i]){
                strikeNum=strikeNum+1
            }
        }
        return strikeNum
    } //스트라이크의 개수를 알려주는 함수

    println("숫자 야구 게임을 시작합니다.")

    while (True){

        var ball:Int = numBall()
        var strike:Int = numStrike()
        var user: Int = 0
        var ifCon:Int

        makeNum()

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

            if(ifCon==1) exitProcess(0)

        }

    }
}


