package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.NumberFormatException


fun main() {

    var uiState :GameUiState = GameUiState.Init
    var computer = emptyList<Int>()


    while (true)
    {
        when(uiState)
        {
            GameUiState.Init->{
                println("숫자 야구 게임을 시작합니다.")
                uiState = GameUiState.Loading
            }
            GameUiState.Loading ->{
                computer = generateRandomNumberList()
                uiState = GameUiState.Playing
            }
            GameUiState.Playing ->{
                gamePlay(computer)
                uiState = GameUiState.Restart
            }
            GameUiState.Restart -> {
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                val input = inputNumber()
                when(input){
                    1-> uiState = GameUiState.Loading
                    2-> uiState = GameUiState.Ending
                    else-> throw IllegalArgumentException()
                }
            }
            GameUiState.Ending ->{
                break
            }
        }
    }
}
fun generateRandomNumberList():List<Int>
{
    val list = mutableListOf<Int>()
    while (list.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!list.contains(randomNumber)) {
            list.add(randomNumber)
        }
    }
    return list
}
fun gamePlay(computer:List<Int>)
{
    val myNumber = mutableListOf<Int>()
    while(true)
    {
        print("숫자를 입력해 주세요 : ")
        var input = inputNumber()

        myNumber.clear()
        while(input>0)
        {
            var num = input % 10
            if(num == 0 || myNumber.contains(num)) throw IllegalArgumentException()
            myNumber.add(num)
            input/=10
        }

        if(myNumber.size != 3) throw IllegalArgumentException()
        myNumber.reverse()

        var strike = 0
        var ball = 0

        for( i in computer.indices)
        {
            if(myNumber[i] == computer[i]) strike++
            if(computer.contains(myNumber[i])) ball++
        }

        ball -= strike
        if(ball>0)
            print("${ball}볼 ")
        if(strike > 0)
            print("${strike}스트라이크")
        if(ball ==0 && strike == 0)
            print("낫싱")
        println()

        if(strike == 3)
        {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }
}
fun inputNumber():Int
{
    var num: Int
    try {
        num = Console.readLine()!!.toInt()
    }catch (e:NumberFormatException)
    {
        throw IllegalArgumentException()
    }
    return num
}
sealed interface GameUiState{
    object Init : GameUiState
    object Playing : GameUiState
    object Loading : GameUiState
    object Restart : GameUiState
    object Ending : GameUiState
}
