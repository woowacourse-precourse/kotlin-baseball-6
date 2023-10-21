package baseball

// 확장 함수로 수정, 접근 제한자를 활용하여 가시성을 최대한 제한하는 것을 권장 -> internal
internal fun String.toUniqueIntArray(): IntArray {
    return this
        .map { it.toString().toInt() }
        .toSet()
        .toIntArray()
}