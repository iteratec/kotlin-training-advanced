Consider the following snippet:

```kotlin
import kotlin.random.Random

fun main() {
    val x = if(Random.nextBoolean()) throw RuntimeException() else 42
}
```

What would be the inferred type of the variable `x`?