
package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var strike = 0
    var ball = 0
    var randomlist = mutableListOf<Int>()
    var inputlist = mutableListOf<Int>()
    while(true) {
        strike = 0
        ball = 0
        randomlist.clear()
        inputlist.clear()
        var input = Console.readLine()
        println(input)

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
                print("end baseball")
                break;

            }
            input = Console.readLine()
        }
        var i = 0
        while(i<3) {
            var temp: Int = input[i].toString().toInt()
            inputlist.add(temp)
            println("i: "+i+"temp: "+temp)
            i++
        }

        for( item:Int in inputlist)
        {
            println("list item: " + item)
        }


        while (randomlist.count() < 3) {
            var randomnum = Randoms.pickNumberInRange(1, 9)
            if (!randomlist.contains(randomnum)) {
                randomlist.add(randomnum)
            }
            println(randomnum)
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
            var output = "낫싱"
            println("결과"+output)
        }else if((strike == 0)&&(ball == 1))
        {
            println("strike: "+strike+" ball: "+ball)
        }else if((strike == 0)&&(ball == 2))
        {
            println("strike: "+strike+" ball: "+ball)
        }else if((strike == 0)&&(ball == 3))
        {
            println("strike: "+strike+" ball: "+ball)
        }else if((strike == 1)&&(ball == 0))
        {
            println("strike: "+strike+" ball: "+ball)
        }else if((strike == 1)&&(ball == 1))
        {
            println("strike: "+strike+" ball: "+ball)
        }else if((strike == 1)&&(ball == 2))
        {
            println("strike: "+strike+" ball: "+ball)
        }else if((strike == 2)&&(ball == 0))
        {
            println("strike: "+strike+" ball: "+ball)
        }else if((strike == 2)&&(ball == 1))
        {
            println("strike: "+strike+" ball: "+ball)
        }else if((strike == 3)&&(ball == 0))
        {
            println("strike: "+strike+" ball: "+ball)
        }
        println("strike: "+strike+" ball: "+ball)



    }
}


