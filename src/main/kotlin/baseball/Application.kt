package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    TODO("프로그램 구현")
}

//랜덤 숫자 생성
fun makeRandomNumber(): String { 
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
        computerNumber.add(randomNumber)
        }
    }
    return computerNumber.joinToString("")
}

 //사용자로부터 숫자를 입력받기
 fun getUserNumber(): String {
    print("숫자를 입력해주세요: ")
    val userInputNumber = Console.readline().toString()
    val userNumber = mutableListOf<Char>()
    
    if (userInputNumber.length != 3) { //예외처리
        throw IllegalArgumentException("숫자를 ${'"'}3개${'"'} 입력해야 합니다.")
    }

    for (char in userInputNumber) { // 입력받은 값을 userNumber에 저장
        userNumber.add(char)
    }

    return userNumber.joinToString("")
}