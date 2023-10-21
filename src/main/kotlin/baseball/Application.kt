package baseball

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val randomTargetGenerator = RandomTargetGenerator()
    val target = randomTargetGenerator.generateRandomTarget()
}