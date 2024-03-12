# Create read-only delegate
In this task we will implement a `lazyPokemon` delegate - a simple version of the `lazy` delegate. 
`lazyPokemon` will execute the provided lambda function that creates a `Pokemon` instance, cache the
created instance and provide it on subsequent calls. To check that the lambda function is called
only once, we'll print a message inside the lambda function.

The provided `main` function...
```kotlin
fun main() {
    val pokemon: Pokemon by simpleLazy {
        println("Creating a Pikachu")
        Pokemon(name = "Pikachu")
    }

    println(pokemon.name)
    println(pokemon.name)
}
```
...should then give the output:
```
Creating a Pikachu
Pikachu
Pikachu
```