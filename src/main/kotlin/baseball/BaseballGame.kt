package baseball

class BaseballGame {

    private val console: BaseballConsole by lazy {
        BaseballConsole()
    }

    fun start() {
        initialize()
    }

    /** TODO
     * Triple 이 좋을지 List 가 좋을지는 생각해봐야할듯.
     * 우선 Triple 자체는 outOfBound가 발생할 일 이 없으므로 조금 더 안정적임
     * 그리고 구조 분해의 장점이 있음
     * 핵심적인 기능은 아니니까. 컴퓨터 - 사용자 숫자 비교할 때 어느게 속도가 빠를지
     */
    private fun initialize(): Triple<Int, Int, Int> {
        console.printWelcomeMessage()

        return Triple(1, 2, 3)
    }
}
