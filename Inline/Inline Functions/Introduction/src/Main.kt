fun main() {
    highOrderFunction {
        println(it)
    }
}

fun highOrderFunction(lambda: (String) -> Unit) {
    lambda("Hello World")
}
