fun printListSize(list: MutableList<*>) {
    println(list.size)
}

fun main() {
    printListSize(mutableListOf(1, 2, 3))
    printListSize(mutableListOf("a", "b"))
}