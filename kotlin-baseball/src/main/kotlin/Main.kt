
fun main(args: Array<String>) {

    var flag = 1

    println("숫자 야구 게임을 시작합니다.")

    while ( flag == 1 ) {
        performBaseballGame(flag)
    }
    println("Hello World!")


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun performBaseballGame(flag : Int): Int {

    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return flag
}