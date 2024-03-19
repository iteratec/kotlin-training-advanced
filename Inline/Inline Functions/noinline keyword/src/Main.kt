fun main() {
    Main().highOrderFunction {
        println(it)
    }
}

class Main {
    fun highOrderFunction(lambda: (String) -> Unit) {
        val value = "value"
        lambda("Hello World")
    }

    private fun privateFunction() {}

    inline fun shinyFunction(inlineLambda: (String) -> Unit, noinline noInlineLambda: (String) -> Unit) {
        val x = noInlineLambda
        highOrderFunction { noInlineLambda("") }
    }
}

