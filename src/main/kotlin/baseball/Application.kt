package baseball

fun main() {

    print("숫자 야구 게임을 시작합니다.")

    //랜덤 정수 생성
    val numProducer = RandomNumProducer()
    var answerList : List<Int> = emptyList()

    answerList = numProducer.makeRandomNum()




}

