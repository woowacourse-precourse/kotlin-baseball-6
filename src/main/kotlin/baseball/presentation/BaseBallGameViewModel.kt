package baseball.presentation

import baseball.util.GameUtils

/**
 * BaseBallGameViewModel
 * 숫자 야구 게임과 관련된 비즈니스 로직을 처리하는 ViewModel 클래스.
 * 게임 로직과 UI를 분리하여 유지보수성, 확장성, 테스트 용이성 등을 높임
 *
 * @param repository 숫자 야구 게임에 필요한 데이터를 관리하는 리포지토리
 */
class BaseBallGameViewModel(private val repository: BaseBallGameRepository) {

    /**
     * setComputerList()
     * 컴퓨터가 선택한 숫자 리스트를 랜덤하게 생성하여 Repository에 설정한다.
     */
    fun setComputerList() {
        repository.setComputerList(GameUtils.getRandomList())
    }

    /**
     * setUserList()
     * 사용자로부터 입력한 숫자를 받아 Repository에 설정한다.
     */
    fun setUserList() {
        repository.setUserList(GameUtils.inputNum())

    }

    /**
     * compareList()
     * 사용자가 입력한 숫자와 컴퓨터가 선택한 숫자를 비교하여 결과를 반환한다.
     * @return 게임 결과를 나타내는 GameModel 객체
     */
    fun compareList() = GameUtils.compareResult(
        userList = repository.getUserList(),
        computerList = repository.getComputerList()
    )

    /**
     * exitOrRestartGame()
     * 사용자로부터 게임 재시작 또는 종료 여부를 입력받는 함수.
     * @return 게임을 재시작하면 true, 게임을 종료하면 false를 반환
     */
    fun exitOrRestartGame(): Boolean = GameUtils.restartGame()

}