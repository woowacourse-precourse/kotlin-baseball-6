package baseball

// TODO : newGenerator()를 일부에서만 접근할 수 있는 방법 학습하고 적용
// TODO : Answer을 object로 선언한 뒤부터 전체 Test를 돌리면 Answer이 적절하게 초기화 되지 않아 오류가 발생함 -> class로 수정할 예정
object Answer {
    private var _number: IntArray = intArrayOf()

    init {
        newGenerator()
    }

    val number: IntArray get() = _number

    internal fun newGenerator() {
        _number = answerSelect()
        println("정답 : ${number.contentToString()}") // TODO For Debuging
    }
}