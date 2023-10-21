package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun computerNum() : MutableList<Int> {
    val computer = mutableListOf<Int>()
    while(computer.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1,9) //랜덤으로 1~9까지 중 숫자 뽑음
        if(!computer.contains(randomNumber)) { //기존 리스트에 숫자가 포함되는지 체크해서
            computer.add(randomNumber) // 겹치는 숫자 없이 추가한다.
        }
    }
    return computer
}

fun playerNum() : MutableList<Int> {
    var player = mutableListOf<Int>()
    print("숫자를 입력해주세요 : ")
    val counter = Console.readLine() // 문자열로 받음
    for(char in counter){ // 각 문자별로 뽑아서
        player.add(Character.digit(char,10)) // 숫자로 변환해 리스트에 추가
    }
    return player
}
fun compare(computer: MutableList<Int>, player: MutableList<Int>) : Pair<Int, Int>{
    var strike = 0
    var ball = 0
    for(i in 0..<player.size){
        if(computer.contains(player[i])){ //컴퓨터에 값이 포함되었는지
            val index = computer.indexOf(player[i]) //포함되면 인덱스 가져와서
            if(i == index){ //위치가 같으면 스트라이크
                strike += 1
            }
            else{
                ball += 1 //위치가 같지 않으면 볼
            }
        }
    }
    return Pair(strike, ball)
}
fun result_message(strike:Int, ball:Int){
    if(strike == 0 && ball == 0) {
        println("낫싱")
    }
    else if(strike == 3){
        println("3스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
    else if(strike == 0){
        println(ball.toString() + "볼")
    }
    else if(ball == 0){
        println(strike.toString() + "스트라이크")
    }
    else{
        println(ball.toString() + "볼 " + strike.toString() + "스트라이크")
    }

}
fun main() {
     /*TODO("프로그램 구현")*/
    val c_number = computerNum() // 컴퓨터의 랜덤 숫자
    val p_number = playerNum() // 플레이어의 숫자
    val (strike, ball) = compare(c_number, p_number) //스트라이크, 볼 비교
    result_message(strike, ball)
}
