package baseball

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

fun main() {
    TODO("프로그램 구현")
}

fun gameStart(){

}

// 랜덤 숫자 생성 함수
// 중복을 제외 시키기 위해 targetNum은 Set으로 설정
// 숫자는 3개
// pickNumberInRange() 함수를 이용해 1~9까지 숫자를 생성
// 랜덤 생성된 숫자는 Int, 입력숫자는 string
// 비교를 위해서 랜덤 숫자를 string으로 바꿈
fun getTargetNumber(targetNum: MutableSet<String>){
    while (targetNum.size < 3) {
        val number = pickNumberInRange(1, 9)
        if (number.toString() !in targetNum) {
            targetNum.add(number.toString())
        }
    }
}

fun getReGameChoice(){

}

fun countBall(){

}

