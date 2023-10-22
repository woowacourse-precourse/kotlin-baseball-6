
package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var strike = 0
    var ball = 0
    var randomlist = mutableListOf<Int>()
    var inputlist = mutableListOf<Int>()
    println("숫자 야구 게임을 시작합니다.")
    while(true) {
        strike = 0
        ball = 0
        randomlist.clear()
        inputlist.clear()

        println("숫자를 입력해주세요")
        var input = Console.readLine()
        //println(input)

        if(input.length>3)
        {
            throw IllegalArgumentException("number length exception")
            //break;
        }
        if(input.length==1)
        {
            var temp2 = input.toString().toInt()
            if (temp2 != 1)
            {
                //print("end baseball")
                break;

            }
            input = Console.readLine()
        }
        var i = 0
        while(i<3) {
            var temp: Int = input[i].toString().toInt()
            inputlist.add(temp)
           //println("i: "+i+"temp: "+temp)
            i++
        }
/*
        for( item:Int in inputlist)
        {
            println("list item: " + item)
        }
*/

        while (randomlist.count() < 3) {
            var randomnum = Randoms.pickNumberInRange(1, 9)
            if (!randomlist.contains(randomnum)) {
                randomlist.add(randomnum)
            }
           // println(randomnum)
        }
        i = 0
        while(i<3) {
            if(inputlist[i]==randomlist[i])
            {
                strike++
            }else {
                if (randomlist.contains(inputlist[i]))
                {
                    ball++
                }
            }
            i++
        }
        if((strike == 0)&&(ball == 0))
        {
            //var output = "낫싱"
            println("낫싱")
        }else if((strike == 0)&&(ball == 1))
        {
            println("1볼")
        }else if((strike == 0)&&(ball == 2))
        {
            println("2볼")
        }else if((strike == 0)&&(ball == 3))
        {
            println("3볼")
        }else if((strike == 1)&&(ball == 0))
        {
            println("1스트라이크")
        }else if((strike == 1)&&(ball == 1))
        {
            println("1볼 1스트라이크")
        }else if((strike == 1)&&(ball == 2))
        {
            println("2볼 1스트라이")
        }else if((strike == 2)&&(ball == 0))
        {
            println("2스트라이")
        }else if((strike == 2)&&(ball == 1))
        {
            println("1볼 2스트라이크")
        }else if((strike == 3)&&(ball == 0))
        {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

            println("숫자를 입력해주세요")
            var start = Console.readLine()
            //println(input)



                var temp2 = start.toString().toInt()
                if (temp2 != 1)
                {
                    //print("end baseball")
                    break;

                }




        }
        //println("strike: "+strike+" ball: "+ball)



    }
}


