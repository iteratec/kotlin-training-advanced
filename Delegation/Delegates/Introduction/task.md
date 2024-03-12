# Delegates
Delegates allow you to implement composition pattern without any boilerplate code. This way, you can create new
classes by combining behaviors implemented in already existing classes.

Delegates use syntax similar to the inheritance syntax. To create a delegate you need to
provide the delegated interface and a constructor parameter that accepts an implementor of this
interface. Both are then combined using the `by` keyword:

```kotlin
interface Greeter {
    fun greet(name: String)
}

class PoliteGreeter : Greeter {
    override fun greet(name: String) {
        println("Hello, $name! Nice to meet you!")
    }
}

class Person(val name: String, greeter: Greeter) : Greeter by greeter

fun main() {
    val alice = Person(name = "Alice", greeter = PoliteGreeter())
    
    // Call will be delegated to the PoliteGreeter instance
    alice.greet("Bob")
}
```
All methods of the delegated interface will be then available directly from the delegating class and will
forward to the interface implementor.

## Multiple delegates
You can specify any number of delegated interfaces:

```kotlin
interface Greeter {
    fun greet(name: String)
}

interface ComplimentTeller {
    fun tellCompliment(name: String)
}

class Person(
    val name: String,
    greeter: Greeter,
    complimentTeller: ComplimentTeller
) : Greeter by greeter, ComplimentTeller by complimentTeller
```

## Overwriting delegated methods
You can overwrite delegated methods and therefore reuse only a subset of methods provided by
the interface implementor:
```kotlin
interface Greeter {
    fun greet(name: String)
    fun sayGoodbye(name: String)
}

class PoliteGreeter : Greeter {
    override fun greet(name: String) {
        println("Hello, $name! Nice to meet you!")
    }

    override fun sayGoodbye(name: String) {
        println("Bye, $name! It was a pleasure!")
    }
}

class Person(val name: String, greeter: Greeter) : Greeter by greeter {

    override fun sayGoodbye(name: String) {
        println("See you, $name!")
    }
}
```