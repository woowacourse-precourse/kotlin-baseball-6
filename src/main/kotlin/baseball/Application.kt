package baseball

//필요한 함수 목록
//1. 문제를 난수로 생성하기, seed값이 인자로 [외장 라이브러리 사용 불가능, 지정된 방식으로 랜덤 구현시 seed 값 할당하는 부분이 없음]
//2. 사용자로 할지 ai로 할지 결정
//3. 사용자의 경우 숫자를 3개 입력 받음
//4. 그 입력과 문제를 비교 후에 정보 출력
//5. 그렇게 끝나면 다시 할지 종료할 지 결정 (무한 루프로 처리하고 종료를 break 처리하자)
//+a 강화학습을 통해서 맞추는 로직 찾기

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

data class Answer(val a: Int, val b: Int, val c: Int)
fun Answer.asList(): List<Int> {
    return listOf(a, b, c)
}
data class Info(var Amount:Int, var out:Int, var bool:Int, var strike:Int)
data class Result(val number : Answer, val info : Info) //3자리로 표현, out,bool,strike 의미

fun Problem(): Answer { //데이터를 생성하려면 문제를 시드에 따라 생성해야 함 seed : Int = System.currentTimeMillis().toInt()
    val a = Randoms.pickNumberInRange(1, 9) // 1부터 9 사이의 정수
    val b = Randoms.pickNumberInRange(1, 9)
    val c = Randoms.pickNumberInRange(1, 9)
    return Answer(a,b,c)
}

fun User_response():Answer { //User용 입력, 여기서 입력 값이 다르면 에러
    print("숫자를 입력해주세요 : ")
    val base = Console.readLine()
    if (base.length != 3) { //서로 다른 수인지도 체크해야 함
        throw IllegalArgumentException()
    }
    return Answer(base[0].toString().toInt(), base[1].toString().toInt(), base[2].toString().toInt()) //toInt로 하면 아스키 코드 값으로 변환됨
}

fun case_check(case:Answer, answer:Answer):Info {
    val info = Info(0,0,0,0)
    //strike체크, bool체크, out으로 감
    val check = answer.asList()
    for ((idx, elem) in case.asList().withIndex()) {
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

fun start_Game(user:Boolean = true){
    val infoList = mutableListOf<Result>() //정보 저장용
    val case = Problem()
    while (true) {
        var answer : Answer
        var tmp = Info(0,0,0,0)
        if (user) {
            answer = User_response()
            tmp = case_check(case, answer) //Answer형태 2개로 결과를 확인 할 수 있게
            display(tmp)// 그 결과를 변환해서 안내메세지를 출력
            infoList.add(Result(answer, tmp)) //이 형태의 값을 넣음
        }
//        elif (user == false) { //ai로 돌림
//            answer = ai_response(infoList) //ai가 뽑으려면 이전의 결과에 대한 정보가 필요
//            tmp = case_check(case, answer) //info형태로 결과를 반환
//            display(tmp)
//            infoList.add(Result(answer, tmp)) //이 형태의 값을 넣음
//        }

        if (tmp == Info(3, 0, 0, 3)) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            break
        }
    }
}

fun main() {
    var restart_Flag = "1"
    println("숫자 야구 게임을 시작합니다.")
    while (restart_Flag == "1") {
        start_Game()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        restart_Flag = Console.readLine()
        if ((restart_Flag != "2") && (restart_Flag != "1")) {
            throw IllegalArgumentException()
        }
    }
}