package baseball.View

import camp.nextstep.edu.missionutils.Console

class UserInput
{
    fun inputUserNumber(): String
    {
        print("숫자를 입력해 주세요 :")
        return Console.readLine()
    }
}
