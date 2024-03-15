# Define collection operators
In this task we'll add the operators `get`, `set` and `contains` to the `Team` class,
which is a simple wrapper for a list of pokemons.

To provide nice API for our `Team` class, we'd like to be able to interact with the
team members directly:

```kotlin
fun main() {
    val team = Team(Pokemon("Pikachu"), Pokemon("Bulbasaur"))
    assertTrue(team[0], Pokemon("Pikachu"))
  
    team[1] = Pokemon("Charmander")
    assertTrue(team[1], Pokemon("Charmander"))
  
    assertTrue(Pokemon("Charmander") in team)
}
```

Implement the mentioned operators.