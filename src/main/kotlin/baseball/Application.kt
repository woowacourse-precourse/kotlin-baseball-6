package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import org.mockito.internal.matchers.text.ValuePrinter.print
import java.lang.System.exit
import java.sql.DriverManager.println
import java.util.ArrayList

fun main() {


    fun makeNum():ArrayList<Int> {
        var ans = ArrayList<Int>(3)
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

    fun getUser(a:Int): ArrayList<Int> {
        var userNum = ArrayList<Int>(3)
        var ans : Int = a

        userNum[0]=a/100
        ans -= 100 * userNum[0]

        userNum[1]=a/10
        ans -= 10 * userNum[1]

        userNum[2]=ans

        return userNum
    }


    fun numBall(a:ArrayList<Int>, b: ArrayList<Int>): Int {
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

    fun numStrike(a:ArrayList<Int>, b:ArrayList<Int>):Int{
        var strikeNum: Int =0
        for (i in 0..2){
            if(a[i]==b[i]){
                strikeNum=strikeNum+1
            }
        }
        return strikeNum
    } //스트라이크의 개수를 알려주는 함수

    println("숫자 야구 게임을 시작합니다.")

    var ball:Int
    var strike:Int
    var ansArray = ArrayList<Int>(3)
    var userString: String
    var user: Int =0
    var userArray = ArrayList<Int>(3)
    var ifCon:Int

    while (true){

        ansArray=makeNum()

        userString = readLine()
        user = userString.toInt()
        userArray = getUser(user)

        ball = numBall(ansArray,userArray)
        strike = numStrike(ansArray,userArray)

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

        if (ansArray==userArray){
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            ifCon = readLine().toInt()

            if(ifCon==1) exit(0)

        }

    }
}


