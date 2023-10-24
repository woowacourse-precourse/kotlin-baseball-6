package baseball

class Game(numbers: MutableList<Int>) {

    //스트라이크 카운팅
    var strikeCount: Int = 0
        private set

    //볼 카운팅
    var ballCount: Int = 0
        private set

    //정답
    var answer = numbers

    //게임을 처음 시작할때 스트라이크와 볼 카운트를 0으로 초기화
    fun initCount() {
        strikeCount = 0
        ballCount = 0
    }

    //스트라이크 갯수를 1개 늘려줌
    fun increaseStrikeCount() {
        strikeCount++
    }

    //볼 갯수를 1개 늘려줌
    fun increaseBallCount() {
        ballCount++
    }
}