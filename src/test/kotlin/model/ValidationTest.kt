package model

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest{

    @ParameterizedTest
    @ValueSource(strings = ["12","1234","숫자"])
    fun `숫자 게임 입력 유효성 테스트`(input:String){
        assertThatThrownBy {
            Validation.checkBaseballNum(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["3","숫자"])
    fun `재시작 혹은 종료 입력 유효성 테스트`(input:String){
        assertThatThrownBy {
            Validation.checkRetry(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("[ERROR]")
    }



}