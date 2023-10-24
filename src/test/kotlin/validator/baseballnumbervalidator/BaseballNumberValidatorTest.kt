package validator.baseballnumbervalidator

import org.junit.jupiter.api.BeforeEach

class BaseballNumberValidatorTest {
    private lateinit var baseballNumberValidator: BaseballNumberValidator

    @BeforeEach
    fun setUp() {
        baseballNumberValidator = BaseballNumberValidatorImpl
    }
}