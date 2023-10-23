package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var restartNum = ""
    print(Dialogues.startGameMessage)
    do {
        var computerNum = generateRandomNum()
        try{
            solveBaseBallGame(computerNum)
        } catch (e:java.lang.IllegalArgumentException){
            return throw IllegalArgumentException("서로 다른 세 자리 숫자를 입력해주세요.")
        }
        print(Dialogues.restartMessage)
        restartNum = Console.readLine()
    } while (restartNum == "1")
    print("게임 종료")
    return
}

fun solveBaseBallGame(computerNum:HashMap<Int, Int>){
    while(true) {
        var userNumHashMap = HashMap<Int, Int>()
        print(Dialogues.requestEnterNumMessage)
        var enterUserNum = Console.readLine()
        println(enterUserNum)
        if (checkCorrectNum(enterUserNum)) {
            userNumHashMap = changeToHashMap(enterUserNum.map { it.toString().toInt() }.toMutableList())
        } else {
            throw IllegalArgumentException("서로 다른 세 자리 숫자를 입력해주세요.")
        }
        var str = compareNum(computerNum, userNumHashMap)
        var result = printBaseBallGameResult(str)
        /// 받아온 문자열로 결과를 확인하는 게 맞을까?
        println(result)
        if(result == "3스트라이크"){
            print(Dialogues.gameOverMessage)
            break
        }

    }
}

fun changeToHashMap(num: MutableList<Int>):HashMap<Int, Int>{
    var hashMap = HashMap<Int, Int>()
    num.forEachIndexed{ index, char ->
        hashMap[char] = index
    }
    return hashMap
}

fun checkCorrectNum(num:String):Boolean{
    if (num.all { it.isDigit() } && num.length == 3 && num.toSet().size == 3) {
        return true
    }
    return false
}

fun generateRandomNum(): HashMap<Int, Int> {
    var computerNum: MutableList<Int> = mutableListOf()
    while (computerNum.size < 3) {
        val randomNumber: Int = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }

    return changeToHashMap(computerNum)
}

fun compareNum(computerNum: HashMap<Int, Int>, userNum: HashMap<Int, Int>): HashMap<String, Int> {
    var resultHashMap:HashMap<String, Int> = hashMapOf(
        "strike" to 0, "ball" to 0, "nothing" to 0
        )
    for ((key, value) in userNum) {
        val hasKey = computerNum.containsKey(key)
        if (hasKey) {
            if (computerNum[key] == value) {
                resultHashMap["strike"] = resultHashMap["strike"]!! + 1
            } else {
                resultHashMap["ball"] = resultHashMap["ball"]!! + 1
            }
        } else {
            resultHashMap["nothing"] = resultHashMap["nothing"]!! + 1
        }
    }
    return resultHashMap
}

fun printBaseBallGameResult(numArray:HashMap<String, Int>):String{
    var strike = numArray["strike"]
    var ball = numArray["ball"]
    var nothing = numArray["nothing"]
    return if(nothing==3){
        Dialogues.nothingMessage
    }else if(strike==3){
        "3${Dialogues.strikeMessage}"
    }else{
        val result = mutableListOf<String>()

        if (ball!! > 0) {
            result.add("${ball}${Dialogues.ballMessage}")
        }

        if (strike!! > 0) {
            result.add("${strike}${Dialogues.strikeMessage}")
        }
        result.joinToString(" ")
    }
}
