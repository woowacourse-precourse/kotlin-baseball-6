package baseball.funcs

// 게임시작 함수
// 게임이 실행되는 함수로 게임시작, 입력, 게임종료 스크립트를 출력
// targetNum 변수를 생성
// getTargeNumber()로 랜덤생성 숫자를 targetNum에 추가
// getInputNumber()로 플레이어로부터 숫자를 입력받아 inputNum에 저장
// countBall()에서 inputNum과 targetNum을 비교해 게임의 결과를 출력
// 3스트라이크시 결과를 출력하며 getReGameChoice()를 통해 게임 재개여부를 물음
// 입력결과에 따라 isPlaying값이 업데이트 되어 게임종료나 재시작이 결정
fun gameStart(){
    val targetNum: MutableSet<String> = mutableSetOf()
    var isPlaying = true
    println("숫자 야구 게임을 시작합니다.")

    while (isPlaying) {
        getTargetNumber(targetNum)
        while (true) {
            print("숫자를 입력해주세요 : ")
            val inputNum = getInputNumber()
            val result = countBall(inputNum, targetNum)
            println(result)

            if (result == "3스트라이크") {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
        isPlaying = getReGameChoice()
    }
}