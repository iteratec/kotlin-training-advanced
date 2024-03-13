# Generic functions
Generics can be also used with standalone functions or with methods of a non-generic class.
In such a case, the type parameter declaration is placed before function's name:

```kotlin
fun <T> firstElement(list: List<T>): T {
    return list.first()
}
```

Generic functions may also specify single or multiple constraints:
```kotlin
fun <T: CharSequence> lengthOfFirstElement(list: List<T>): Int {
    return list.firstOrNull()?.length ?: 0
}

fun <T> lengthOfMinimalElement(list: List<T>): Int where T : CharSequence, T : Comparable<T> {
    return list.minOrNull()?.length ?: 0
}
```

Generic functions will usually be used to provide functionality, that involves usage of other generic types.
For instance, you could return the first element of a collection in a type-safe way or perform some
operation on collection's elements (possibly constrained by an upper bound).