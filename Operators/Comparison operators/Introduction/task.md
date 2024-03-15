# Comparison operators

Kotlin's comparison operators are closely related to `equals` method and `Comparable<T>` interface:

| Operator | Translation                     | Description           |
|----------|---------------------------------|-----------------------|
| `a == b` | a?.equals(b) ?: (b === null)    | Object equality       |
| `a != b` | !(a?.equals(b) ?: (b === null)) | Object inequality     |
| `a > b`  | a.compareTo(b) > 0              | Greater than          |
| `a < b`  | a.compareTo(b) < 0              | Less than             |
| `a >= b` | a.compareTo(b) >= 0             | Equal or greater than |
| `a <= b` | a.compareTo(b) <= 0             | Equal or less than    |

In Kotlin's standard library `equals` and `compareTo` are defined as operator functions. You can
easily check this by examining the `Any` type or `Comparable` interface:

```kotlin
open class Any {
    open operator fun equals(other: Any?): Boolean { }    
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}
```
