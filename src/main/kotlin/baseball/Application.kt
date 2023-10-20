package baseball
import camp.nextstep.edu.missionutils.Randoms
/*
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
*/
fun main(){
    var keepPlaying: Boolean
    do {
        println("숫자 야구 게임을 시작합니다.")
        val cN = randNumber()
        var strikeCount = 0

        while (strikeCount != 3) {
            //println(cN) // 나중에 바꿀꺼
            strikeCount = compareNumber(cN)
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        keepPlaying = readLine()?.toLowerCase() == "1"

    } while (keepPlaying)

    println("게임을 종료합니다. 감사합니다!")
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
fun inputNumber(): List<Int> {            // 반환값 정수다
    var input = readLine()!!.toString() // 이변수는 null이 아니다
    if(input.contains('0')
        || input.length !=3
        || ((input[0] == input[1]) || (input[1] == input[2]) || (input[2] == input[0]))) {
        throw IllegalArgumentException("")
    }
    return input.map { it.toString().toInt() } // 문자열에서 숫자 리스트로 변환
}

fun compareNumber(cN : List<Int>): Int {        //비교, 출력
    // var aa = cN //이게 아니라 randNumber의 computer을 받아와야한느데, 이렇게하면 새로운 숫자가생성됨
    print("숫자를 입력해주세요 :")
    val userNumbers = inputNumber()
    var strikeCount: Int = 0
    var ballCount: Int = 0
    for (i in 0..2) {
        if (userNumbers[i] == cN[i]) {
            strikeCount++
        } else if (cN.contains(userNumbers[i])) {
            ballCount++
        }
    }
    when {
        strikeCount != 0 && ballCount != 0 -> println("${ballCount}볼 ${strikeCount}스트라이크")
        strikeCount != 0 -> println("${strikeCount}스트라이크")
        ballCount != 0 -> println("${ballCount}볼")
        else -> println("낫싱")
    }
    return strikeCount
}


//when이용해 간략하게 바꾸기
    /*
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
     */








