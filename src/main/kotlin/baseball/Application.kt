package baseball

fun main() {


    //랜덤 정수 생성
    val numProducer = RandomNumProducer()
    val gameCalculator = GameCalculator()
    var answerList : List<Int> = emptyList()
    var inputList : List<Int> = emptyList()
    var gameResult : GameResult

    answerList = numProducer.makeRandomNum()

    answerList.forEach { println(it) }

    //게임 시작
    print("숫자 야구 게임을 시작합니다.\n")

    while(true) {
        //문자열 입력
        try {
            print("숫자를 입력해주세요 : ")
            val inputNum = readlnOrNull()
            //입력 받지 않았거나 숫자 3자리로 구성되어 있지 않은 경우  에러 처리
            if (inputNum != null && inputNum.length == 3) {
                inputList = checkInput(inputNum)

            } else throw IllegalArgumentException("압력 값은 숫자 3자리로 구성되어야 합니다.")

            //게임 시작
           gameResult = gameCalculator.calculate(answerList, inputList)

            if(gameResult.strike==0 && gameResult.ball==0){
                println("낫싱")
            }else{
                println(gameResult.ball.toString()+ "볼" + " " +gameResult.strike.toString() + "스트라이크" )

                    if(gameResult.strike==3) {
                        //게임종료
                        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

                    }
            }


        } catch (e: IllegalArgumentException) {
            println("오류 발생 :${e.message}")
        }
    }
}


fun checkInput(input : String) : List<Int> {
    val intList : MutableList<Int> = mutableListOf()

    //문자열을 문자 배열로 변환
    val array : Array<String> = input.toCharArray().map {
        it.toString()
    }.toTypedArray()

    //문자 배열을 숫자 배열로 변환
    array.forEach {
        val num = it.toIntOrNull() ?: throw IllegalArgumentException("압력 값은 숫자 3자리로 구성되어야 합니다.")
        intList.add(num)
    }

    return intList

}


