package baseball
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    print("숫자를 입력해주세요 : ")
    var number:Int = readLine()!!.toInt()
    println("당신이 입력한 숫자는 ${number}입니다.")

    var com1:String
    var com2:String
    var com3:String

    com1 = pickNumberInRange(0,9)!!.toString()
    com2 = pickNumberInRange(0,9)!!.toString()
    com3 = pickNumberInRange(0,9)!!.toString()
    while(com2 == com1) com2 = pickNumberInRange(0,9)!!.toString();
    while(com3 == com1 || com3 == com2) com3 = pickNumberInRange(0,9)!!.toString();

    var comNumber = com1 + com2 + com3;
    println("컴퓨터의 숫자는 ${comNumber}입니다.")

}


