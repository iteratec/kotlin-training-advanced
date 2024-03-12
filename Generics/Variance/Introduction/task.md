# Generic type variance
Variance defines how generic types relate to the inheritance structure of their type parameters.
For instance, given the parent type `CharSequence` and its subtype `String` we could ask if we can
treat the generic type `MutableList<String>` as a subtype of `MutableList<CharSequence>`.

In theory there are few variance types: invariant types, covariant types and contravariant types.

## Invariance
Consider the following example:
```kotlin
var charSeqList: MutableList<CharSequence> = mutableListOf()
var stringList: MutableList<String> = mutableListOf()

charSeqList = stringList

// Now stringList is broken - it contains a StringBuilder
charSeqList.add(StringBuilder()) 
```
When treating `MutableList<String>` as `MutableList<CharSequence>`, we could easily break the list by inserting
elements, that inherit from `CharSequence`, but not from `String`. Therefore, `MutableList<String>` cannot be 
safely treated as a subtype of `MutableList<CharSequence>`. We'd say that these types are _invariant_.

By default, generics in Kotlin are invariant. It's possible to make a generic type covariant or
contravariant, if you impose constraints on how the generic type parameter is used.

## Covariance
Let's tweak the previous example a bit and use immutable lists instead:
```kotlin
var charSeqList: List<CharSequence> = listOf(StringBuilder())
var stringList: List<String> = listOf("a", "b", "c")

charSeqList = stringList
charSeqList.last()
```
This example, although very similar, is perfectly valid! Since the lists are immutable, we have no possibility to 
break the list of strings as before. It's fine to treat `List<String>` as `List<CharSequence>` as long as
you only _read_ list's elements, because every `String` is `CharSequence`.

Kotlin supports the `out` keyword in the generic declaration. It allows to "enable" covariance with the
constraint, that the type parameter can be only produced from generic type. It cannot be passed as a method
parameter or as property value.

```kotlin
class ValueHolder<out T>(private val value: T) {
    fun get(): T = value

    // Won't compile as T is used in "in" position
    fun set(value: T) { }
}
```

## Contravariance
Contravariance can be thought as an opposite of covariance. It allows you to "invert" the type hierarchy and
treat general types as their subtypes. Consider the following example:

```kotlin
class LengthPrinter<in T : CharSequence> {
    fun print(value: T) {
        println("Length = ${value.length}")
    }
}

fun main() {
    val printer: LengthPrinter<CharSequence> = LengthPrinter()
    val stringPrinter: LengthPrinter<String> = printer

    printer.print(StringBuilder("builder"))
    stringPrinter.print("string")
    stringPrinter.getLastPrinted() 
}
```
Here, we treat an instance of `LengthPrinter<CharSequence>` as `LengthPrinter<String>` and therefore a list
with a more general type parameter (`CharSequence`) is assignable to a list with a more specialized type parameter (`String`).
This is possible, because `LengthPrinter` only _consumes_ the generic type parameter. The method
`LengthPrinter<CharSequence>.print()` will work with any subtype of `CharSequence`, so the whole generic type can be
assigned to a more specialized type like `LengthPrinter<String>` or `LengthPrinter<StringBuilder>`.

Contravariant types are supported in Kotlin via `in` keyword. Contravariant types can only consume the type parameter
and cannot return it from any method or property. 

## Recap
* Invariant types
  * Are declared without any modifier: `class Value<T> {}`
  * Cannot be assigned to any other generic type
* Covariant types
  * Are declared using the `out` keyword: `class Value<out T> {}`
  * Can only produce the type parameter.
  * `Value<Child>` is assignable to `Value<Parent>`
* Contravariant types
  * Are declared using the `in` keyword: `class Value<in T> {}`
  * Can only consume the type parameter.
  * `Value<Parent>` is assignable to `Value<Child>`