package baseball.model.validation

private val validations by lazy {
    listOf<Validation>(
        PositiveNumberValidation(),
        OutOfRangeNumberValidation(),
        InvalidLengthValidation(),
        DuplicateNumberValidation()
    )
}

fun String.checkValidation() {
    validations.forEach { validation -> validation.check(this) }
}