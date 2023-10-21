package baseball

import camp.nextstep.edu.missionutils.Randoms
/*
기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
예) 상대방(컴퓨터)의 수가 425일 때
123을 제시한 경우 : 1스트라이크
456을 제시한 경우 : 1볼 1스트라이크
789를 제시한 경우 : 낫싱
위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
입출력 요구 사항
입력
서로 다른 3자리의 수
게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수*/
fun main() {
    gameStart()
}

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
    var computerNumber: ArrayList<Int> = answerNumber()
    while (true) {
        val myNumber: ArrayList<Int> = input()
        println(myNumber)
        println(computerNumber)
        if (!comparisonNumber(myNumber, computerNumber)) {
            if (!reGame()) {
                break
            } else {
                computerNumber = answerNumber()
            }
        }
    }
}

fun input(): ArrayList<Int> {
    print("숫자를 입력해주세요 : ")
    val number = readln()
    val numberList: ArrayList<Int> = arrayListOf()
    if (number.length != 3) {
        throw IllegalArgumentException("잘못된 입력입니다. 3개의 숫자를 입력하세요")
    }
    try {
        for (i in 0..2) {
            numberList.add(number[i].digitToInt())
        }
        return numberList
    } catch (e: IllegalArgumentException) {
        throw e
    }
}

fun answerNumber(): ArrayList<Int> {
    val computer: ArrayList<Int> = arrayListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
fun comparisonNumber(myNumber: ArrayList<Int>, computerNumber: ArrayList<Int>): Boolean {
    var strike: Int = 0
    var ball: Int = 0
    repeat(3) { index ->
        repeat(3) {
            if (computerNumber[index] == myNumber[it] && index == it) {
                strike++
            } else if (computerNumber[index] == myNumber[it] && index != it)
                ball++
        }
    }
    when {
        strike == 3 -> {
            println("3스트라이크")
            return false
        }

        strike + ball == 0 -> {
            println("낫싱")
            return true
        }

        strike == 0 -> {
            println("${ball}볼")
            return true
        }

        ball == 0 -> {
            println("${strike}스트라이크")
            return true
        }

        else -> {
            println("${ball}볼 ${strike}스트라이크")
            return true
        }
    }
//    return if (!myNumber.containsAll(computerNumber)) {
//        repeat(3) { index ->
//            repeat(3) {
//                if (computerNumber[index] == myNumber[it] && index == it) {
//                    strike++
//                }
//                else if (computerNumber[index] == myNumber[it] && index != it)
//                    ball++
//            }
//        }
//        when {
//            strike == 3 -> {
//                println("3스트라이크")
//                return false
//            }
//
//            strike + ball == 0 -> {
//                println("낫싱")
//                return true
//            }
//            strike == 0 -> {
//                println("${ball}볼")
//                return true
//            }
//            ball == 0 -> {
//                println("${strike}스트라이크")
//                return true
//            }
//            else -> {
//                println("${ball}볼 ${strike}스트라이크")
//            }
//        }
//
//        true
//    } else {
//        println("3스트라이크")
//        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
//        false
//    }
}
fun reGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val choice = readln().toInt()
    return when (choice) {
        1 -> true
        2 -> false
        else -> {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
    }
}