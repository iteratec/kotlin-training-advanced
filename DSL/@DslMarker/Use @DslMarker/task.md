# Use @DslMarker
In this task, we'll improve an existing Pokemon DSL™ by adding the `@DslMarker` annotation.
Use `@DslMarker` to make sure, that only `skill` method can be called in the `skills` lambda:

```kotlin
fun main() {
    val pikachu = pokemon {
        weight = 2
        skills {
          skill(name = "Electrocute", power = 10)
          
          // Should not be possible, weight has nothing do to with skills
          weight = 42 
        }
    }
}
```