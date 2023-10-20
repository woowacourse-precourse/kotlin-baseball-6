package baseball

//필요한 함수 목록
//1. 문제를 난수로 생성하기, seed값이 인자로
//2. 사용자로 할지 ai로 할지 결정
//3. 사용자의 경우 숫자를 3개 입력 받음
//4. 그 입력과 문제를 비교 후에 정보 출력
//5. 그렇게 끝나면 다시 할지 종료할 지 결정 (무한 루프로 처리하고 종료를 break 처리하자)
//+a 강화학습을 통해서 맞추는 로직 찾기

import kotlin.random.Random
data class Answer(val a: Int, val b: Int, val c: Int)

fun problem(seed : Int): Answer {
    val random = Random(seed)
    val a = random.nextInt(1, 9) // 1부터 9 사이의 정수
    val b = random.nextInt(1,9)
    val c = random.nextInt(1, 9)
    return Answer(a,b,c)
}

fun User_response():Answer {
    val base = readln()
    if (base.length != 3) {
        throw IllegalArgumentException()
    }
    return Answer(base[0].toString().toInt(), base[1].toString().toInt(), base[2].toString().toInt()) //toInt로 하면 아스키 코드 값으로 변환됨
}

fun main() {
    println(problem(0))
    println(User_response())
}
