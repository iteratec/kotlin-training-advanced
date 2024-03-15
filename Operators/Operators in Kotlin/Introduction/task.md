# Operators in Kotlin
Kotlin supports a large number of built-in operators like (e.g. `+`, `in`, `..`) and almost every of those
operators may be overloaded to provide custom behavior.

Operators in Kotlin follow a pretty simple concept - for every operator there's a corresponding function that
will be called, when the operator is used. The mapping between the operator and the function can be found in
[Kotlin's documentation](https://kotlinlang.org/docs/operator-overloading.html). Here are few examples:

| Operator | Translated to                |
|----------|------------------------------|
| -a       | a.unaryMinus()               |
| a + b    | a.plus(b)                    |
| a[i]     | a.get(i)                     |
| a[i, j]  | a.get(i, j)                  |
| a == b   | a?.equals(b) ?: (b === null) |
| a > b    | a.compareTo(b) > 0           |

Kotlin compiler will replace all operator calls with the corresponding translations:
```kotlin
fun main() {
    val a = 40
    val b = 2

    // Compiler will translate the operator call to a.plus(b)
    val c = a + b
}
```

## Overloading operators
You can overload operators by defining operator functions. Operator functions are marked with the `operator` keyword:

```kotlin
class Color(val red: Int, val green: Int, val blue: Int) {
    operator fun plus(other: Color): Color {
        return Color(
            red = red + other.red,
            green = green + other.green,
            blue = blue + other.blue
        )
    }

   override fun toString(): String {
        return "[red=$red, green=$green, blue=$blue]"
   }
}

fun main() {
    val red = Color(red = 100, green = 0, blue = 0)
    val blue = Color(red = 0, green = 0, blue = 100)
    println(red)
    println(blue)
    println(red + blue)
}
```

Kotlin doesn't impose any constraints on the types produced or consumed by an operator, but
it's a good practice to adhere to mathematical properties of the given operator. For instance,
the `plus` operator should usually consume and produce the same type as the declaring
class (e.g Int + Int -> Int).

## Multiple overloads
Since operators are basically just functions, you can have many overloads for a given operator.
This allows us to use an operator with different types:

```kotlin
class Color(val red: Int, val green: Int, val blue: Int) {
    operator fun plus(amount: Int): Color {
        return Color(
            red = red + amount,
            green = green + amount,
            blue = blue + amount
        )
    }

    override fun toString(): String {
        return "[red=$red, green=$green, blue=$blue]"
    }
}

fun main() {
    val red = Color(red = 100, green = 0, blue = 0)
    println(red + 12)
}
```

## Operator overloading and polymorphism
Similarly to regular functions, operators do __not__ support double dispatch. If multiple operators would
match the given argument, the declared type of the argument will be used to resolve the operator (not the
actual runtime type of the argument). Consider the following example:

```kotlin
open class Color(val red: Int, val green: Int, val blue: Int) {
    operator fun plus(other: Color): Color {
        return Color(
            red = red + other.red,
            green = green + other.green,
            blue = blue + other.blue
        )
    }

    operator fun plus(other: TransparentColor): TransparentColor {
        return TransparentColor(
            red = red + other.red,
            green = green + other.green,
            blue = blue + other.blue,
            alpha = other.alpha
        )
    }

    override fun toString(): String {
        return "[red=$red, green=$green, blue=$blue]"
    }
}

class TransparentColor(
    red: Int,
    green: Int, 
    blue: Int,
    val alpha: Int
): Color(red, green, blue) { 
    override fun toString(): String {
        return "[red=$red, green=$green, blue=$blue, alpha=$alpha]"
    }
}

fun main() { 
    val red = Color(red = 100, green = 0, blue = 0) 
    val transparentBlue: Color = TransparentColor(
        red = 0, 
        green = 0, 
        blue = 100, 
        alpha = 50
    )

    // Will produce Color because transparentBlue is declared as Color 
    println(red + transparentBlue)
}
```

## Operator overloading and inheritance
Overloaded operators will be inherited just like any other method. Keep in mind, that
this is usually not what you want - inherited operators don't know anything about the
subclass and will most probably produce instances of the parent class.

Operators of the parent class may be overwritten, but they have to be declared as `open`.

## Operators as extension functions
Kotlin allows to add operators to existing classes via extension functions. This allows
you to define operators for classes, that you don't own:

```kotlin
operator fun Color.plus(other: Color): Color {
    return Color(
        red = red + other.red,
        green = green + other.green,
        blue = blue + other.blue
    )
}
```

Operators defined as extension functions won't overwrite an operator already defined
in a class.

## Best practices
* Overload operators only when the operation naturally fits into the domain. For instance,
adding `Money` instances is fine, but adding `Cookie` instances is confusing.
* Operators should always be pure functions.
* Operator function should never perform any side effects (e.g. perform IO operations)
* Try to design operator functions, so that they never throw an exception.
* Operator function should be fast.
* Try to adhere to the mathematical properties of the overloaded operator
 (e.g. commutativity & associativity).
* Use operator overloading only with final classes, since operator overloading and inheritance is confusing.
* Overloaded operators may be used as one of DSL components
