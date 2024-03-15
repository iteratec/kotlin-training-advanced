# Define arithmetic operators
In this task we'll define `plus` and `times` operators on a `Potion` class.
`Potion` class models modifiers that can affect combat abilities of a pokemon: 

```kotlin
class Potion(
  val attack: Int,
  val defense: Int
) 
```

We'd like to be able to combine any number of potions and receive a single potion, that
sums up the effects of all combined potions. For that, we just add the corresponding stats:

```kotlin
fun main() {
    val attackPotion = Potion(attack = 10)
    val defensePotion = Potion(defense = 5)
    val berserkerPotion = Potion(attack = 20, defense = -10)

    // Combined potion is: Potion(attack = 30, defense = -5)
    val combinedPotion = attackPotion + defensePotion + berserkerPotion
}
```

Similarly, we want to be able to multiply the effect of a potion by an integer number:
```kotlin
fun main() {
    val potion = Potion(attack = 10, defense = 5)
    
    // Doubled potion is Potion(attack = 20, defense = 10)
    val doubledPotion = potion * 2
}
```
Define the corresponding operators in the `Potion` class. What could we do to provide commutative
potion multiplying, so that the expression `2 * potion` is valid as well?