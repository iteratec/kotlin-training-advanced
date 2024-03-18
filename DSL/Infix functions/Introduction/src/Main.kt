infix fun Boolean.nand(other: Boolean): Boolean = this.and(other).not()

fun main() {
    val intPair: Pair<Int, Int> = 5 to 10
    val intRange: IntRange = 0 until 5
    "Hello, World" matches "^Hello".toRegex()
}
