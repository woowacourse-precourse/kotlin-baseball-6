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
data class Info(val Amount:Int, val out:Int, val bool:Int, val strike:Int)
data class result(val number : Answer, val info : Info) //3자리로 표현, out,bool,strike 의미

fun problem(seed : Int): Answer { //문제를 시드에 따라 생성
    val random = Random(seed)
    val a = random.nextInt(1, 9) // 1부터 9 사이의 정수
    val b = random.nextInt(1,9)
    val c = random.nextInt(1, 9)
    return Answer(a,b,c)
}

fun User_response():Answer { //User용 입력
    val base = readln()
    if (base.length != 3) {
        throw IllegalArgumentException()
    }
    return Answer(base[0].toString().toInt(), base[1].toString().toInt(), base[2].toString().toInt()) //toInt로 하면 아스키 코드 값으로 변환됨
}

fun start_Game(user:Boolean == true){
    val infoList = mutableListOf<Info>() //정보 저장용
    val Answer case = problem()
    while (true): {
        if (user == true) {
            val answer = User_response()
            val tmp = case_check(case, answer) //Answer형태 2개로 결과를 확인 할 수 있게
             display(tmp)// 그 결과를 변환해서 안내메세지를 출력
        }
        elif (user == false) { //ai로 돌림
            val answer = ai_response(infoList) //ai가 뽑으려면 이전의 결과에 대한 정보가 필요
            val tmp = case_check(case, answer) //info형태로 결과를 반환
            display(tmp)
        }
        infoList.add(answer, tmp) //이 형태의 값을 넣음

        if (tmp == Info(3, 0, 0, 3)) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }
}

fun main() :
    start_Game(user=true)
}
