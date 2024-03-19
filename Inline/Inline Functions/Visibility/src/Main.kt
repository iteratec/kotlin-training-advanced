// Wont compile

//fun main() {
//    val main = Main()
//
//    main.publicInlineFun { main.privateFun() }
//}
//
//class Main {
//
//    private fun privateFun(): Int {
//        return 42
//    }
//
//    inline fun publicInlineFun(lambda: () -> Unit) {
//        lambda()
//        privateFun()
//    }
//}
