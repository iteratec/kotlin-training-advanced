# Reified keyword
## Motivation
As in Java, Kotlin generic types are erased at runtime. This leads to limitations, when we'd like to perform
type checking or casting, that involves a generic type. Consider the following code snippet:

```kotlin
open class Pokemon(val name: String) {
    override fun toString(): String = name
}
class WaterPokemon(name: String): Pokemon(name)
class FirePokemon(name: String): Pokemon(name)

fun <T: Pokemon> containsPokemonType(list: List<Pokemon>): Boolean {
    // Won't compile, because T will be erased at runtime
    return list.any { it is T }
}

fun main() {
    val pokemons = listOf(
        WaterPokemon(name = "Squirtle"),
        WaterPokemon(name = "Staryu"),
        FirePokemon(name = "Charmander")
    )
    
    val hasWaterPokemon = containsPokemonType<WaterPokemon>(pokemons)
    println(hasWaterPokemon)
}
```

In the `containsPokemonType` function we'd like to check, if the list contains a pokemon of the given type. The type
is specified as a generic parameter. The above implementation sadly won't compile - the generic type T will be
erased at runtime, so we don't have enough information to perform the type check. A workaround would be to pass
the class we want to check against as a parameter:

```kotlin
fun <T: Pokemon> containsPokemonType(
    list: List<Pokemon>, 
    clazz: Class<T>
): Boolean {
    return list.any { clazz.isInstance(it) }
}
```

## How reified works
Kotlin provides a more elegant solution to this problem - reified generic types. You can make
the function `inline` and mark the generic type with the `reified` keyword:

```kotlin
inline fun <reified T: Pokemon> containsPokemonType(list: List<Pokemon>): Boolean {
    return list.any { it is T }
}
```

This code will compile without problems and you can call the function without passing the
extra `Class<T>` parameter: `containsPokemonType<WaterPokemon>(list)`.

Under the hood, Kotlin compiler will copy-paste the function's body in every call and replace
the generic type with the actual one (so no type erasure actually happens). In our example
the compiler would produce code similar to the following one:
```kotlin
fun main() {
    // Original call...
    val hasWaterPokemon = containsPokemonType<WaterPokemon>(pokemons)
    
    // ...becomes replaced. Function's body is pasted on the method call
    // and generic param is resolved to a non-generic one.
    val hasWaterPokemon = pokemons.any { it is WaterPokemon }
}
```

Reified type parameters are applicable only to generic functions and the function must be
declared as `inline`.

## Usage
Usage of the `reified` keyword is fairly limited to the situations, where you use type checking
or casting together with generic types. A good practical example is Jackson's object mapper, that
will return a type-casted instance based on the passed generic type.

```kotlin
fun main() {
    val mapper = ObjectMapper()
    val pokemon: Pokemon = mapper.readValue<Pokemon>("""{ "name": "Pikachu" }""")
}
```