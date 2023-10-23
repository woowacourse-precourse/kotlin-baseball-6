package baseball.ui

import baseball.ui.model.GameModel
import baseball.util.GameUtils

/**
 * BaseBallGameViewModel
 * 숫자 야구 게임과 관련된 비즈니스 로직을 처리하는 ViewModel 클래스.
 * 게임 로직과 UI를 분리하여 유지보수성, 확장성, 테스트 용이성 등을 높임
 *
 * @param repository 숫자 야구 게임에 필요한 데이터를 관리하는 리포지토리
 */
class BaseBallGameViewModel(private val repository: BaseBallGameRepository) {


    // repository 의 setComputerList() 호출
    fun setComputerList() = repository.setComputerList()

    // repository 의 setUserList() 호출
    fun setUserList() = repository.setUserList()

    // repository 의 compareList() 호출
    fun compareList(): GameModel = repository.compareList()

    /**
     * exitOrRestartGame()
     * 사용자로부터 게임 재시작 또는 종료 여부를 입력받는 함수.
     * @return 게임을 재시작하면 true, 게임을 종료하면 false를 반환
     */
    fun exitOrRestartGame(): Boolean = GameUtils.restartGame()
}