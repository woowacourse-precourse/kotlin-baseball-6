package baseball

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val model = model.BaseballModel()
    val view = view.BaseballView()
    val controller = Controller(model, view)

    controller.run()
}
