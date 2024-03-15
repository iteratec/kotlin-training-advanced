# Define invoke operator
In this task we'll implement `invoke` operator on the provided `Transform` class.
The `Transform` class model a geometric transformation of a pokemon. It can move the
pokemon to another position and scale its size.

When a pokemon is transformed:
* the `positionChange` is added to the pokemon's `position`
* the `scaleChange` is multiplied with the pokemon's `size`

Implement the `invoke` operator, so that the `main()` function produces the desired output.

```kotlin
fun main() {
    val moveForwardAndScale = Transform(positionChange = 1, scaleChange = 2)

    val pikachu = Pokemon(name = "Pikachu")
    println(moveForwardAndScale(pikachu))

    val charmander = Pokemon(name = "Charmander")
    println(moveForwardAndScale(charmander))
    
    // Should print:
    // Pikachu is at position 4 and has size 2
    // Charmander is at position 2 and has size 4  
}
```