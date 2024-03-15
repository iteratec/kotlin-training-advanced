# Unary operators
Unary operators work with a single argument (e.g `+42` or `-42`). Kotlin supports a small number of unary operators:

| Operator | Translation    |
|----------|----------------|
| `+a`     | a.unaryPlus()  |
| `-a`     | a.unaryMinus() |
| `!a`     | a.not()        |
| `a++`    | a.inc()        |
| `a--`    | a.dec()        |

All operator rules discussed in the previous lesson apply to unary operators. There are few rules, that
unary operators should follow (unless you want to be hated by fellow developers):

* Unary operators should not mutate the object, but return a modified copy instead
* Unary operators should return object of the same type

Incrementation and decremenation have few special rules:
* They must be called directly on variables (`var`):
  ```kotlin
    val x = 2++ // Invalid because called on literal
    val y = 2; y++ // Invalid because of val
    var z = 2; z++ // Valid 
  ```
* They can be used in a prefix or postfix notation (`++a`, `a++`)

Here's a simple example of a class that defines custom unary operators:
```kotlin
class Money(val amount: Int, val currency: String) {
    operator fun unaryPlus(): Money = Money(amount = abs(amount), currency = currency)
    operator fun unaryMinus(): Money = Money(amount = -abs(amount), currency = currency)
    operator fun not(): Money = Money(amount = -amount, currency = currency)
    override fun toString(): String {
        return "$amount $currency"
    }
}

fun main() {
    val money = Money(amount = 42, currency = "EUR")
    println(+money)
    println(-money)
    println(!money)
    println(!-money)
}
```