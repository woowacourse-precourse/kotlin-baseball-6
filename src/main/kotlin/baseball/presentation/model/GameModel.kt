package baseball.presentation.model
/**
 * GameModel
 * 게임 결과를 저장하는 데이터 클래스. 스트라이크, 볼 및 낫싱 정보를 포함
 *
 * @param strike 스트라이크 개수 (기본값: 0)
 * @param ball 볼 개수 (기본값: 0)
 * @param nothing 낫싱 여부 (기본값: false)
 */
data class GameModel (
    val strike : Int = 0,
    val ball : Int= 0,
    val nothing: Boolean = false
)