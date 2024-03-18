# Infix functions
Kotlin supports so-called infix functions, which allow you to bring your DSL closed to 
natural language. Infix functions are prefixed with the `infix` keyword and may be called
without parenthesis and without a dot:

```kotlin
infix fun Boolean.nand(other: Boolean): Boolean = this.and(other).not()

fun main() {
    println(true.nand(true))
    println(true nand true)
}
```

Kotlin has few built-in infix functions that well illustrate their usage:

```kotlin
fun main() {
    val intPair: Pair<Int, Int> = 5 to 10
    val intRange: IntRange = 0 until 5
    "Hello, World" matches "^Hello".toRegex()
}
```

## Constraints
Not all functions may be marked as `infix`. A function has to meet the following constraints:
* must be a member function or an extension function
* must have a single parameter
* the parameter is not `varargs` and doesn't have default value

## Usages
Infix functions are just syntactic sugar. They can make you code more readable, but also
less consistent, if not used with care. Simple factory or operator-like functions are usually
good candidates for an infix function. A good example of an infix function is `version` used in Gradle DSL:

```kotlin
plugins { 
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
}
```

Functions with multiple overloads and different parameter number shouldn't be marked as
infix as this makes the API less consistent:

```kotlin
infix fun String.withoutPrefix(prefix: String) = this.removePrefix(prefix)
fun String.withoutPrefix(prefix: String, repeat: Int): String {
    var tmp = this
    repeat(repeat) { tmp = tmp.removePrefix(prefix) }
    return tmp
}

fun main() {
    val first = "blabla text" withoutPrefix "bla"
    
    // A non-infix call of overloaded function is required. Confusion arises.
    val second = "blabla text".withoutPrefix("bla", 2)
}
```