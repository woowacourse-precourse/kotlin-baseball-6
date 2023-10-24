package baseball

import kotlin.*
import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.ArrayList


fun main() {

    fun makeNum():ArrayList<Int> {
        var ans = ArrayList<Int>(3)
        var ran1: Int
        var ran2: Int
        var ran3: Int

        ran1 = Randoms.pickNumberInRange(1, 9)
        ans.add(ran1)

        do{ ran2 = Randoms.pickNumberInRange(1, 9)
        } while(ran2==ran1)
        ans.add(ran2)

        do{ ran3 = Randoms.pickNumberInRange(1, 9)
        }while(ran3==ran2 || ran3==ran1)
        ans.add(ran3)

        return ans

    } //서로 다른 3자리의 수를 가진 배열 생성

    fun getUser(a:Int): ArrayList<Int> {
        var userNum = ArrayList<Int>(3)
        var ans : Int = a

        userNum.add(a/100)
        ans -= 100 * userNum[0]

        userNum.add(ans/10)
        ans -= 10 * userNum[1]

        userNum.add(ans)

        return userNum
    } //유저의 입력 값을 ArayList로 자료형 변환

    fun ifInputError(a:String):Boolean {
        if(a.length!=3) return true
        return false
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


    var ball:Int
    var strike:Int
    var ansArray = ArrayList<Int>(3)
    var userString: String
    var user: Int
    var userArray = ArrayList<Int>(3)
    var ifCon:Int

    print("숫자 야구 게임을 시작합니다.\n")

    while(true){

        ansArray=makeNum()

        do{
            print("숫자를 입력해주세요 : ")

            try {
                userString = readLine()
                ifInputError(userString)
            }catch(e:NullPointerException){return}

            if(ifInputError(userString)){
            throw (IllegalArgumentException())}


            try {
                user = userString.toInt()
            }catch(e:NumberFormatException){ return }


            userArray = getUser(user)

            ball = numBall(ansArray, userArray)
            strike = numStrike(ansArray, userArray)


            if(ball > 0){
                print(ball)
                print("볼 ")
            }

            if (strike > 0) {
                print(strike)
                print("스트라이크")
            }

            if((ball == 0)&&(strike == 0)){
                print("낫싱")
            }

            print("\n")

        }while(ansArray!=userArray)

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        try{
        ifCon = readLine().toInt()
        }catch(e:NumberFormatException) { return  }
        catch(e:NullPointerException){return}

        if(ifCon==2) return

        }

    }




