# Generic constraints
Quite often you want to set an upper bound on a generic type. This is usually the case, when your
generic class uses some base functionality of the type parameter class. Consider the following example:

```kotlin
open class Pokemon(val sound: String)
class Pikachu : Pokemon("Pika pika") {
    fun thunderShock() {
        println("Pikachu used thunder shock!")
    }
}

class Pokeball<T : Pokemon>(private val pokemon: T?) {
    fun examinePokeballSounds() {
        if (pokemon != null) {
            println("Pokeball produces a quiet ${pokemon.sound}")
        } else {
            println("Pokeball is silent as a grave.")
        }
    }
}
```
Here, we rely on the fact, that every instance used with our generic `Pokeball` class is a subclass
of `Pokemon`. With this constraint we're able to use methods specific to `Pokemon` in our generic class.

The simplest way to specify a generic constraint in Kotlin is to use the `MyClass<T : TUpper>` syntax,
where `TUpper` is the upper bound of the type parameter. That means, that our generic will accept only
type parameters of type `TUpper` or its subclasses.

In more complex cases you may need to specify multiple constraints. For instance, when you require that
the type parameter has to implement few specific interfaces. In that case Kotlin provides an alternative
syntax `where T : FirstInterface, T : SecondInterface`. The `where` clause comes after the primary
constructor of a class:

```kotlin
open class Pokemon
class Pikachu : Pokemon(), Serializable

class Pokeball<T>(private val pokemon: T) where T : Pokemon, T : Serializable

fun main() {
    val pokeball = Pokeball(Pikachu())

    // Won't compile because the Serializable constraint is not satisfied
    val anotherPokeball = Pokeball(Pokemon()) 
}
```

When multiple constraints are specified, the type parameter must implement all of them in order to be
usable with the given generic type.