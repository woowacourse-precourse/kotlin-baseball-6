package baseball.Controller

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator()
{
    private var computerNumbers = mutableListOf<Int>()

    fun createComputerNumbers(): MutableList<Int>
    {
        computerNumbers.clear()
        while (computerNumbers.size < 3)
        {
            val randomNumbers = Randoms.pickNumberInRange(1, 9)
            if (!computerNumbers.contains(randomNumbers)) {
                computerNumbers.add(randomNumbers)
            }
        }
        println("컴퓨터 번호 $computerNumbers")
        return computerNumbers
    }
}