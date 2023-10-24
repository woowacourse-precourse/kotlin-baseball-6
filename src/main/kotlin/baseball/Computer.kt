import camp.nextstep.edu.missionutils.Randoms

class Computer {
    var answer : MutableList<Int> = mutableListOf()

    fun makeNewAnswer() {
        answer = mutableListOf()
        while (answer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber)
            }
        }
    }
}