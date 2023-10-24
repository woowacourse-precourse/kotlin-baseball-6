package baseball.ui

import baseball.ui.model.GameModel

/**
 * BaseBallGameRepository
 * 숫자 야구 게임 데이터를 관리하는 리포지토리 인터페이스.
 * Facade 패턴을 사용해 ViewModel에게 단순한 인터페이스를 제공
 */
interface BaseBallGameRepository{
    fun setComputerList()
    fun setUserList()
    fun compareList(): GameModel
}