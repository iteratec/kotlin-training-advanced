# Arithmetic operators

| Operator | Translation    | Description           |
|----------|----------------|-----------------------|
| `a + b`  | a.plus()       | Addition              |
| `a - b`  | a.minus()      | Substraction          |
| `a * b`  | a.times()      | Multiplication        |
| `a / b`  | a.div()        | Division              |
| `a % b`  | a.rem()        | Reminder              |
| `a..b`   | a.rangeTo()    | Range (end inclusive) |
| `a..<b`  | a.rangeUntil() | Range (end exclusive) |

Kotlin allows to overload any arithmetic operator. Additionally, Kotlin provides
two range operators that allow you to easily instantiate a range of the given
type. Classes that define range operators should implement `Comparable`. Range 
operators are supported by default by numeric types.

Here's a small example of `rangeTo` operator:
```kotlin
class Level(private val value: Int): Comparable<Level> {
    
    operator fun rangeTo(toLevel: Level): ClosedRange<Level> {
        TODO("Create a range")
    }

    override fun compareTo(other: Level): Int {
        return value - other.value
    }
}
fun main() {
    val from1To3: IntRange = 1..3
    val from1To2: IntRange = 1..<3

    val minLevel = Level(1)
    val maxLevel = Level(100)
    val fanyRange: ClosedRange<Level> = minLevel..maxLevel
}
```

If you're interested in ranges, you may want to check out range interfaces from the standard library:
* `ClosedRange<T>` - range that contains its end
* `OpenEndRange<T>` - range that doesn't contain its end
* `Iterable<T>` - ranges are usually iterable so they can be used in loops 
