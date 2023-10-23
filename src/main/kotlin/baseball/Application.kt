package baseball

import java.util.Random // Random 사용을 위한 메소드 import

fun main() {
    // 게임 시작
    println("숫자 야구 게임을 시작합니다.")
    var baseball_com = Random().nextInt(500) + 1
    println(baseball_com)
}
