package baseball
import camp.nextstep.edu.missionutils.Randoms

/*
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var computerNumber = RandomNumber()
    print("숫자를 입력해주세요 :")
    var guessNumber = readLine()
    var result = Result(guessNumber)
    if(check(guessNumber)){
        println("$guessNumber")
    }
    else{
        throw IllegalArgumentException("종료 되었습니다.")
    }


}
fun check(guessNumber: String?): Boolean {
    if (guessNumber == null || guessNumber.length != 3) return false
    if (guessNumber.contains('0')) return false

    return guessNumber[0] != guessNumber[1] && guessNumber[0] != guessNumber[2] && guessNumber[1] != guessNumber[2]
}

class RandomNumber(){       // 랜덤으로 1~9까지중 3개 뽑기
    val computer = mutableListOf<Int>()
    init {
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }
}


class Result(var message : Int) {
    fun resultStrike() {
        while (true) {
            if(){

            }

        }
    }
}
*/

var strikeCount : Int = 0
var ballCount : Int = 0
fun main(){
    println("숫자 야구 게임을 시작합니다.")
    val pick = randNumber()
    println(pick)
    do{
        print("숫자를 입력해주세요 :")
        var number = inputNumber()

        var cN = compareNumber()
        cN
    } while(strikeCount != 3)

}
fun randNumber(): List<Int> {
    var computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
fun inputNumber(): String {            // 반환값 정수다
    var input = readLine()!!.toString() // 이변수는 null이 아니다
    if(input.contains('0')
        || input.length !=3
        || (input[0] == input[1] && input[1] == input[2] && input[2] == input[0])) {
        throw IllegalArgumentException("종료 되었습니다.")
    }
    return input
}
fun compareNumber(){
    var aa = randNumber().toString()
    var bb = inputNumber()
    for(i in 0..2){
        for(j in 0..2){
            if (bb[j] == aa[i] && bb[j] == aa[j]){
                strikeCount++
                continue
            }else if(bb[j] == aa[i]){
                ballCount++
                continue
            }else{

            }
        }

        if(strikeCount !=0 && ballCount !=0){
            println("${ballCount}볼 ${strikeCount}스트라이크")
        }else if(strikeCount != 0 && ballCount == 0){
            println("${strikeCount}스트라이크")
        }else if(strikeCount == 0 && ballCount != 0){
            println("${ballCount}볼")
        }else if(strikeCount ==0 && ballCount ==0){
            println("낫싱")
        }else{

        }
    }
}

fun reOrStop(){
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var choice = readLine().toString()
    if(choice == "1"){
        //프로그램 종료
    }else if(choice == "2"){
        //프로그램
    }else{

    }
}




