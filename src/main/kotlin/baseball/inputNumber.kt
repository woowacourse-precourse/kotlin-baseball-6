package baseball


fun inputNumber(): List<Int> {                              // 입력값 설정
    var input = readLine()!!.toString()
    if(input.contains('0')
        || input.length !=3
        || ((input[0] == input[1]) || (input[1] == input[2]) || (input[2] == input[0]))) {
        throw IllegalArgumentException()
    }
    return input.map {it.toString().toInt()}
}

