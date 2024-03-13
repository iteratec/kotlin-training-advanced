# Using star-projection
In this task we want to write a function `isInfoComplete` that checks if the given `PokemonInfo`
object is complete. `PokemonInfo` is a generic type with `CharSequence` as upper type parameter
bound. It contains pokemon's `name` and `description`, where both are nullable values.

The function `isInfoComplete` should return `true` if both `name` and `description` are non-null.
Otherwise, `false` should be returned.

Use star-projection, so that you function works with any `PokemonInfo` flavour:
```kotlin
fun main() {
    isInfoComplete(PokemonInfo(name = "Pikachu", description = null))
    
    isInfoComplete(PokemonInfo(
        name = StringBuilder("Pikachu"),
        description = StringBuilder("Cute mouse"))
    )
}
```

Both name and description are mutable properties. Feel free to experiment to see what happens
when you read or set them in the `isInfoComplete` function.