package baseball.data.repository

import baseball.ui.BaseBallGameRepository

/**
 * BaseBallGameRepositoryImpl
 * 숫자 야구 게임 데이터를 관리하는 리포지토리 구현 클래스.
 */
class BaseBallGameRepositoryImpl : BaseBallGameRepository {
    private lateinit var computerList: List<Int>
    private lateinit var userList: List<Int>

    override fun setComputerList(list: List<Int>) {
        computerList = list
    }

    override fun setUserList(list: List<Int>) {
        userList = list
    }

    override fun getComputerList(): List<Int> = computerList

    override fun getUserList(): List<Int> = userList

}