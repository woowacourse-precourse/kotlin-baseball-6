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

    /**
     * setComputerList()
     * 컴퓨터가 중복되지 않는 3자리 숫자를 랜덤하게 생성하여 computerList에 설정한다.
     */
    override fun setComputerList() {
        computerList = GameUtils.getRandomList()
    }

    /**
     * setUserList()
     * 사용자로부터 입력한 숫자를 받아 userList에 설정한다.
     */
    override fun setUserList() {
        userList = GameUtils.inputNum()
    }

    /**
     * compareList()
     * 사용자가 입력한 숫자와 컴퓨터가 선택한 숫자를 비교하여 결과를 반환한다.
     * @return 게임 결과를 나타내는 GameModel 객체
     */
    override fun compareList(): GameModel = GameUtils.compareResult(
        computerList = computerList,
        userList = userList
    )

}