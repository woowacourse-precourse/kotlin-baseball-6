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
fun main() {
     /*TODO("프로그램 구현")*/
    val c_number = computerNum() // 컴퓨터의 랜덤 숫자
    val p_number = playerNum() // 플레이어의 숫자
    print(p_number)
}
