package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main(args: Array<String>) {
    // TODO 제일 큰 while문 만들고 그 안에 중첩 while문에 println("숫자야구시작") 다음 단계부터 넣기

    loop@ while (true) {
        val answerArray = Array(3, { 0 })    // 숫자
        val myAnswerArray = Array(3, { 0 })  // 내가 입력한 숫자

        for (i: Int in 0..2) {  // 정답 배열 저장
            answerArray[i] = Randoms.pickNumberInRange(1, 9)
            print(answerArray[i])  // 맞게 저장됐는지 출력해보기
        }
        println()

        println("숫자 야구를 시작합니다.")  // 시작

        while (true) {
            print("숫자를 입력해주세요 : ")
            val myAnswer = readLine()
            //println("입력한 숫자 : " + myAnswer)

            if (myAnswer.isNullOrBlank()) {  // isNullOrEmpty()랑 다름
                continue
            } else if (myAnswer.length > 3 || myAnswer.length <= 2) {
                println("3자리 숫자를 입력해주세요.")
                continue
            } else {  // 입력받은 숫자(문자열) 나눠서 int로 변환하고 myAnswerArray에 저장
                val myAnswer1 = myAnswer?.substring(0 until 1)
                myAnswerArray[0] = myAnswer1!!.toInt()
                val myAnswer2 = myAnswer?.substring(1 until 2)
                myAnswerArray[1] = myAnswer2!!.toInt()
                val myAnswer3 = myAnswer?.substring(2)
                myAnswerArray[2] = myAnswer3!!.toInt()
                //println("${myAnswerArray[0]} ${myAnswerArray[1]} ${myAnswerArray[2]}") ok

                // 문자열 슬라이싱 하고 변환하는 것을 한줄에 할 수는 없을지?
                // !!. 뭔지 찾아보기
            }

            var strike = 0  // strike의 타입 추론해냄. var strike : Int = 0
            var ball = 0

            if (myAnswerArray[0] == answerArray[0]) strike++
            else if (myAnswerArray[0] == answerArray[1]) ball++
            else if (myAnswerArray[0] == answerArray[2]) ball++

            if (myAnswerArray[1] == answerArray[1]) strike++
            else if (myAnswerArray[1] == answerArray[0]) ball++
            else if (myAnswerArray[1] == answerArray[2]) ball++

            if (myAnswerArray[2] == answerArray[2]) strike++
            else if (myAnswerArray[2] == answerArray[0]) ball++
            else if (myAnswerArray[2] == answerArray[1]) ball++

            if (ball != 0)
                print("${ball}볼 ")
            if (strike !=0)
                print("${strike}스크라이크")
            println()

            if (strike == 3) {  //3스트라이크
                println(
                    """
                    3개의 숫자를 모두 맞히셨습니다! 게임 종료
                    게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
                """.trimIndent()
                )
                var number = readLine()!!.toInt()

                if (number == 1)
                    continue@loop
                else if (number == 2)
                    break@loop
                else {
                    while (number != 1 && number != 2) {
                        println("1 또는 2를 입력해주세요.")
                        number = readLine()!!.toInt()
                        continue
                    }
                }
            }
            else {
                continue
            }
        }
    }

}








