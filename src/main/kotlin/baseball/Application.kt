package baseball
import camp.nextstep.edu.missionutils.Randoms

fun computer_num() : MutableList<Int> {
    val computer = mutableListOf<Int>()
    while(computer.size < 3){
        val randomNumber = Randoms.pickNumberInRange(1,9) //랜덤으로 1~9까지 중 숫자 뽑음
        if(!computer.contains(randomNumber)) { //기존 리스트에 숫자가 포함되는지 체크해서
            computer.add(randomNumber) // 겹치는 숫자 없이 추가한다.
        }
    }
    return computer
}
fun main() {
     /*TODO("프로그램 구현")*/
    val c_number = computer_num() // 컴퓨터의 랜덤 숫자
    print(c_number)
}
