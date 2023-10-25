package baseball
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        var com1: Int
        var com2: Int
        var com3: Int

        com1 = pickNumberInRange(0, 9) // computer picks first number in range 0~9
        com2 = pickNumberInRange(0, 9) // computer picks second number in range 0~9
        com3 = pickNumberInRange(0, 9) // computer picks third number in range 0~9
        while (com2 == com1) com2 = pickNumberInRange(0, 9) // if 1st = 2nd number -> retry pick up the number
        while (com3 == com1 || com3 == com2) com3 =
            pickNumberInRange(0, 9) // if 2nd == 3rd or 1st == 3rd -> retry pick up the number

        var command = 1
//        print("숫자를 입력해주세요 : ")
//        var number: Int = readLine()!!.toInt() // input three number
//        println("당신이 입력한 숫자는 ${number}입니다.")


        var ball = 0 // ball counter
        var strike = 0 // strike counter

        while(strike != 3) {
            var number = userInput()

            var user3: Int = number % 10 // user's third number
            var user2: Int = (number / 10) % 10 // user's second number
            var user1: Int = (number / 100) % 10 // user's first number

            println("1: ${user1} 2: ${user2} 3: ${user3}") // check

            if (user1 == user2 || user2 == user3 || user3 == user1) { // input error handler
                IllegalArgumentException()
                return;
            };


            when (user1) { // Compare the number of computers with the first number of users
                com1 -> strike++
                com2 -> ball++
                com3 -> ball++
            }
            when (user2) { // Compare the number of computers with the second number of users
                com1 -> ball++
                com2 -> strike++
                com3 -> ball++
            }
            when (user3) { // Compare the number of computers with the third number of users
                com1 -> ball++
                com2 -> ball++
                com3 -> strike++
            }

            if (strike == 3) {
                println("3스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("개임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
                command = readLine()!!.toInt()
            } else {
                if (ball != 0 && strike != 0) println("${ball}볼 ${strike}스트라이크")
                else if (ball == 0 && strike != 0) println("${strike}스트라이크")
                else if (ball != 0 && strike == 0) println("${ball}볼")
                else println("낫싱")
                ball = 0 // initialize
                strike = 0 // initialize
            }
        }
    } while (command == 1)
}

fun userInput(): Int {
    print("숫자를 입력해주세요 : ")
    var number: Int = readLine()!!.toInt() // input three number
    println("당신이 입력한 숫자는 ${number}입니다.")

    return number
}