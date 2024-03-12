interface Greeter {
    fun greet(name: String)
    fun sayGoodbye(name: String)
}

class PoliteGreeter  : Greeter{
    override fun greet(name: String) {
        println("Hello, $name! Nice to meet you!")
    }

    override fun sayGoodbye(name: String) {
        println("Bye, $name!")
    }
}

class Person(val name: String, greeter: Greeter) : Greeter by greeter {

    override fun sayGoodbye(name: String) {
        println("See you, $name!")
    }
}

fun main() {
    val alice = Person(name = "Alice", greeter = PoliteGreeter())

    // Call will be delegated to PoliteGreeter instance
    alice.greet("Bob")
    alice.sayGoodbye("Bob")
}
