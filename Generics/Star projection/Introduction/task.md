# Star projection
Sometimes you don't really know or care what type parameter a generic type has. Consider
the following code:

```kotlin
fun printListSize(list: MutableList<*>) {
    println(list.size)
}

fun main() {
    printListSize(mutableListOf(1, 2, 3))
    printListSize(mutableListOf("a", "b"))
}
```

Here, we don't really care about the type parameter, because we use intrinsic properties of the
list. At the same time, we want our function to be able to work with any list.

For such cases Kotlin provides star-projection `Type<*>`. It is similar to `Type<?>` from Java.
Star projection allows us to safely work with generics with unknown type parameters and compiler
makes sure, that we won't "break" the generic type by inserting invalid values.

Using star-projection has the following effects:
* When reading from the generic type, we'll always get upper bound of the type parameter or `Any?` if no upper 
bound is defined
* We cannot write into the generic type. For generic parameter in 'in' positions, `Nothing` will be the only type that
you can use.

```kotlin
interface Vector<T: Number> {
    fun set(index: Int, value: T)
    fun get(index: Int): T
}

fun test(vector: Vector<*>) {
    // Number is the upper bound
    val firstElement: Number = vector.get(0)
    
    // Won't compile - we can't insert anything into Vector, because we don't know which type it holds
    vector.set(0, 3) 
}
```