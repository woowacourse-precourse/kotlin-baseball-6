package baseball

class GameManager {
    companion object{
        fun start(){
            printStartMessage()
        }

        // 최초 실행 시 게임 시작 문구 출력
        private fun printStartMessage(){
            println("숫자 야구 게임을 시작합니다.")
        }

    }
}