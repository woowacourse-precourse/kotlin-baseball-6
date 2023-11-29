package baseball.domain.util

fun List<Int>.hasSize(size: Int): Boolean =
    this.size == size

fun List<Int>.allInRange(range: IntRange): Boolean =
    this.all { it in range }

fun List<Int>.doesNotHaveDuplicates(): Boolean =
    this.size == this.toSet().size