# Create read-write delegate
In this task we want to provide functionality similar to an audit log. Write a read-write property delegate
that fulfills the following criteria:

* The delegate takes a string as initial value.
* Every time when the property is read, we'll print an according message:
  ```
  Property {name} has been read and has value {value}
  ```

* Similarly, when the property is modified, we'll print the message:
  ```
  Property {name} changed from {old value} new {new value}
  ```

For instance, the following `main` function...
```kotlin
fun main() {
    val pokemon = Pokemon(name = "Pikachu")
    println(pokemon.name)
    pokemon.name = "Squirtle"
}

class Pokemon {
  var name: String by audited("Pikachu")
}
```

...should provide the following output:
```
Property name has been read and has value Pikachu
Pikachu
Property name changed from Pikachu to Squirtle
```