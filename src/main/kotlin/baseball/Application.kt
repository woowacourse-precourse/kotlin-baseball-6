import kotlin.random.Random
package baseball

fun main() {
    val array = mutableListOf<Int>()

    for (i in 1..3) {
        val num = Random.nextInt(1, 10)
        array.add(num)
    }

    for (num in array) {
        println(num)
    }
    //TODO("프로그램 구현")
    //1부터 9까지의 숫자, 랜덤으로 생성


}

//fun createNum(): [Int] {
//
//
//    return result
//}


fun checkNum() {
    //숫자가 중복인지 아닌지 판단
}
