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
fun Answer.asList(): List<Int> {
    return listOf(a, b, c)
}
data class Info(var Amount:Int, var out:Int, var bool:Int, var strike:Int)
data class result(val number : Answer, val info : Info) //3자리로 표현, out,bool,strike 의미

fun Problem(seed : Int): Answer { //문제를 시드에 따라 생성
    val random = Random(seed)
    val a = random.nextInt(1, 9) // 1부터 9 사이의 정수
    val b = random.nextInt(1,9)
    val c = random.nextInt(1, 9)
    return Answer(a,b,c)
}

fun User_response():Answer { //User용 입력, 여기서 입력 값이 다르면 에러
    val base = readln()
    if (base.length != 3) {
        throw IllegalArgumentException()
    }
    return Answer(base[0].toString().toInt(), base[1].toString().toInt(), base[2].toString().toInt()) //toInt로 하면 아스키 코드 값으로 변환됨
}

fun case_check(case:Answer, answer:Answer):Info {
    val info = Info(0,0,0,0)
    //strike체크, bool체크, out으로 감
    val check = listOf(answer)
    for ((idx, elem) in listOf(case).withIndex()) {
        if (elem == check[idx]) { //data class에서 get, set인 인덱스 접근에 해당하는 함수를 만들어 가능하게 할 수 있음
            info.strike += 1
            info.Amount += 1
        }
        else if (elem in check) {
            info.bool += 1
            info.Amount +=1
        }
        else {
            info.out += 1
        }
    }
    return info
}

fun display(show:Info){
    if (show.Amount == 0) {
        println("낫싱")
        return
    }
    if (show.bool > 0) {
        print("${show.bool}볼")
    }

    //아래의 if문은 리스트로 공간을 만들고 출력하는 형태로 처리할 수 있음
    if (show.bool != 0 && show.bool != show.Amount) { //정보 양과 같으면 아직 안끝난 것
        print(" ")
    }

    if (show.strike > 0) {
        print("${show.strike}스트라이크")
    }
    println()
}
//
//fun start_Game(user:Boolean = true){
//    val infoList = mutableListOf<Info>() //정보 저장용
//    val case = Problem(0)
//    while (true) {
//        if (user == true) {
//            val answer = User_response()
//            val tmp = case_check(case, answer) //Answer형태 2개로 결과를 확인 할 수 있게
//             display(tmp)// 그 결과를 변환해서 안내메세지를 출력
//        }
//        elif (user == false) { //ai로 돌림
//            val answer = ai_response(infoList) //ai가 뽑으려면 이전의 결과에 대한 정보가 필요
//            val tmp = case_check(case, answer) //info형태로 결과를 반환
//            display(tmp)
//        }
//        infoList.add(result(answer, tmp)) //이 형태의 값을 넣음
//
//        if (tmp == Info(3, 0, 0, 3)) {
//            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
//            break
//        }
//    }
//}

fun main() {
//    start_Game(user=true)
    display(Info(2,1,2,0))
    display(Info(2,1,1,1))
    display(Info(2,1,0,2))
}
