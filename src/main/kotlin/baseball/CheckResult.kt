package baseball

object CheckResult {
    fun Result(computer: List<Int>, input: String): String{
        var ballCount = 0
        var strikeCount = 0

        input.forEachIndexed{index, char ->
            if(computer[index].toString() != char.toString() && computer.contains(char - '0')){
                ballCount += 1
            }

            if(computer[index].toString() == char.toString()){
                strikeCount += 1
            }
            //println("input.indexOf(computer.toString()):  ${input.contains(computer.toString())}")

        }
        var result_string = RESULT_NOTHING_MESSAGE

        if(ballCount != 0){
            if(strikeCount != 0){
                result_string = StringBuilder(ballCount.toString()).append(RESULT_BALL_MESSAGE).append(" ").append(strikeCount.toString()).append(RESULT_STRIKE_MESSAGE).toString()
            }
            else{
                result_string = StringBuilder(ballCount.toString()).append(RESULT_BALL_MESSAGE).toString()
            }
        }
        else if(strikeCount != 0){
            result_string = StringBuilder(strikeCount.toString()).append(RESULT_STRIKE_MESSAGE).toString()
        }

    return result_string
    }
}
