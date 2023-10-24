package baseball

fun main() {

    // 인스턴스 생성
    val model = model.BaseballModel()
    val view = view.BaseballView()
    val controller = Controller(model, view)

    view.printGameStart() // 게임 시작 문구 출력
    controller.run()     // 컨트롤러 실행
}
