package baseball

class Message {
    fun message(type:String){
        if (type == "strike") {
            System.out.println("3스트라이크")
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        }
    }
    fun scoreMessage(strike:Int,ball:Int,out:Int){
        if (out == 3) {
            System.out.println("낫싱")
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball.toString() + "볼")
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike.toString() + "스트라이크")
        } else {
            System.out.println(ball.toString() + "볼 " + strike.toString() + "스트라이크")
        }
    }
}