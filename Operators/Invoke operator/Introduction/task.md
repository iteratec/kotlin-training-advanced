## Invoke operator
| Operator  | Translation    | Description          |
|-----------|----------------|----------------------|
| `a()`     | a.invoke()     | Invoke a             |
| `a(i, j)` | a.invoke(i, j) | Invoke a with params |

Invoke operator is a special operator that can be defined in a class, allowing instances
of that class to be called as if they were functions:

```kotlin
class Retry(private val maxAttempts: Int) {
    operator fun invoke(block: () -> Unit) {
        var lastThrowable: Throwable? = null
        
        repeat(maxAttempts) {
            try { 
                block()
            } catch (e: Throwable) {
                lastThrowable = e
            }
        }
        
        throw IllegalStateException("Retry failed", lastThrowable)
    }
}

fun main() {
    val retry = Retry(maxAttempts = 3)
    
    // Same as retry.invoke({ /* lambda */ })
    retry {
        // Do something that can fail
    }
}
```

### Usage
`invoke` operator is a pretty special one and is used mainly in DSL contexts. You may
consider to use `invoke` when you have a class that performs one core operation, but
requires complex configuration. In that sense, an object with `invoke` operator can be viewed
as curried function (object's properties correspond to curried function's parameters).

Frequent use cases for `invoke` operator are:

* Command pattern - the command's object operation can be implemented as `invoke`
* Builders in DSL - builders usually expose only one function like `build(configLambda)`. With `invoke` you can
  expose this operation in a cleaner way.
* Providing a factory function - `invoke` on companion object can be used to provide a factory function that looks like
a constructor (it's a bit hacky though)