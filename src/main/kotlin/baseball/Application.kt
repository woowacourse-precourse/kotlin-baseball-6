package baseball

fun main() {


    //랜덤 정수 생성
    val numProducer = RandomNumProducer()
    val gameCalculator = GameCalculator()
    var answerList : List<Int>
    var inputList : List<Int>
    var gameResult : GameResult
    var programFinish: Boolean = false

    answerList = numProducer.makeRandomNum()

    //게임 시작
    print("숫자 야구 게임을 시작합니다.\n")

    while(!programFinish) {
//        answerList.forEach { println(it) }
        //문자열 입력
        try {
            print("숫자를 입력해주세요 : ")
            val inputNum = readlnOrNull()

            //입력 받지 않았거나 숫자 3자리로 구성 되어 있지 않은 경우  에러 처리

            inputList = checkInput(inputNum)


            //게임 시작
           gameResult = gameCalculator.calculate(answerList, inputList)

            if(gameResult.strike==0 && gameResult.ball==0){
                println("낫싱")
            }
            else if(gameResult.ball==0 && gameResult.strike!=3) println(gameResult.strike.toString() + "스트라이크" )
            else if(gameResult.strike==0) println(gameResult.ball.toString() + "볼" )
            else{
                println(gameResult.ball.toString()+ "볼" + " " +gameResult.strike.toString() + "스트라이크" )

                    if(gameResult.strike==3) {
                        //게임 종료
                        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        println("게임을 새로 시작 하려면 1, 종료 하려면 2를 입력하세요.")

                        val restartInput = readlnOrNull()

                        if(restartInput == "1"){
                            val newNumProducer = RandomNumProducer()
                            answerList = newNumProducer.makeRandomNum()
                        }
                        else if(restartInput == "2") programFinish = true
                        else throw IllegalArgumentException("1이나 2 중 하나를 입력 해야 합니다.")


                    }
            }


        } catch (e: IllegalArgumentException) {

            programFinish = true
          
        }
    }
}


//숫자 3자리의 배열로 입력되어 있는지 확인 후 int 배열 return
fun checkInput(input : String?) : List<Int> {
    val intList : MutableList<Int> = mutableListOf()

    if(input== null) throw IllegalArgumentException("압력 값은 서로 다른 0~9까지의 숫자 3자리로 구성 되어야 합니다.")

    //문자열을 문자 배열로 변환
    val array : Array<String> = input.toCharArray().map {
        it.toString()
    }.toTypedArray()

    if(array.distinct().size!=3) throw IllegalArgumentException()
    //문자 배열을 숫자 배열로 변환
    array.forEach {
        //숫자가 아닌 문자가 입력된 경우
        val num = it.toIntOrNull()
        if(num == null || num ==0 ) throw IllegalArgumentException("압력 값은 서로 다른 0~9까지의 숫자 3자리로 구성 되어야 합니다.")
        intList.add(num)
    }

    return intList

}


