package baseball.view

class OutputView {
    init {
        Start()
        NumInput()
        InputView()
    }
    private class Start{
        init {
            println("숫자 야구 게임을 시작합니다.")
        }
    }
    private class NumInput {
        init {
            print("숫자를 입력해주세요 : ")
        }
    }
}

