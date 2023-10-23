package baseball.data.repository

import baseball.ui.BaseBallGameRepository
import baseball.ui.model.GameModel
import baseball.util.GameUtils

/**
 * BaseBallGameRepositoryImpl
 * 숫자 야구 게임 데이터를 관리하는 리포지토리 구현 클래스.
 */
class BaseBallGameRepositoryImpl : BaseBallGameRepository {
    private lateinit var computerList: List<Int>
    private lateinit var userList: List<Int>

    override fun setComputerList() {
        computerList = GameUtils.getRandomList()
    }

    override fun setUserList() {
        userList = GameUtils.inputNum()
    }

    override fun compareList(): GameModel = GameUtils.compareResult(
        computerList = computerList,
        userList = userList
    )

}